{{/* vim: set filetype=mustache: */}}

{{/*
Create chart name
*/}}
{{- define "chart" -}}
{{- printf "%s" .Chart.Name | replace "+" "_" | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Common labels
*/}}
{{- define "labels" -}}
app: {{ include "chart" . }}
env: {{ .Values.env }}
{{- end -}}

{{/*
Kind naming for deployments, services, service account, etc. Chart name plus env name
*/}}
{{- define "fullname" -}}
{{ include "chart" . }}-{{ .Values.env }}
{{- end -}}

{{/*
Common selector labels for the template and containers itself
*/}}
{{- define "selectorLabels" -}}
app: {{ .Chart.Name }}
env: {{ .Values.env }}
{{- end -}}

{{/*
Image fullname image.repo/image.imageName:image.tag
*/}}
{{- define "image-fullname" -}}
{{ .Values.image.repo }}{{ .Values.image.imageName }}:{{ .Values.image.tag }}
{{- end -}}

{{/*
Annotations. Provide the possibility to include/exclude Kubernetes Service Account annotation for the workloadIdentity usage
*/}}
{{- define "workloadIdentity" -}}
annotations:
  iam.gke.io/gcp-service-account: {{ .Values.workloadIdentity.gsa_name }}@{{ .Values.workloadIdentity.gcp_project_id }}.iam.gserviceaccount.com
{{- end -}}

{{/*
Returns default port 80 if not .Values.service.port was specified
*/}}
{{- define "service-port" -}}
{{ .Values.service.port | default 80 }}
{{- end -}}

{{/*
Lookup for .Values.newRelic.key Secret in .Values.newRelic.namespace namespace and returns
environent NEW_RELIC_LICENSE_KEY variable with value of the secret.
Its supposed to pull new-relic api key from "newrelic-key" Secret in "new-relic" namespace, that is needed to be pre-created in cluster.
*/}}
{{- define "get-newrelic-secret" -}}
{{- $namespace := .Values.newRelic.namespace | default "new-relic" }}
{{- $key_name := .Values.newRelic.key | default "newrelic-key" }}
{{- $key := (lookup "v1" "Secret" $namespace $key_name) }}
- name: NEW_RELIC_LICENSE_KEY
  value: {{ if $key }}{{ $key.data.NEW_RELIC_LICENSE_KEY | b64dec }}{{else}}{{ end }}
{{- end -}}

{{/*
Returns environment variables:
- name: NEW_RELIC_LICENSE_KEY
  value: <new-relic key>
- name: NEW_RELIC_APP_NAME
  value: <generated name>
*/}}
{{- define "inject-newrelic-secret" }}
{{- if .Values.newRelic.enabled }}
- name: NEW_RELIC_APP_NAME
  value: {{ if .Values.envVars.NEW_RELIC_APP_NAME }}{{.Values.envVars.NEW_RELIC_APP_NAME}}{{else}}{{ include "fullname" . }}-gke{{end}}
{{ include "get-newrelic-secret" . }}
{{ end }}
{{- end }}

{{/*
Returns environment JAVA_TOOL_OPTIONS env variable if {{ .Values.javaOpts }} is set up:
- name: JAVA_TOOL_OPTIONS
  value: {{ .Values.javaOpts }}
*/}}
{{- define "inject-javaopts-secret" -}}
{{- if .Values.javaOpts }}
- name: JAVA_TOOL_OPTIONS
  value: {{ .Values.javaOpts }}
{{- end }}
{{- end -}}

{{/*
Parses .Values.envVars for '<ENV_VAR_NAME>: ${k8s_secret://<secretname>/<secret-key>}'
and mounts this secrets as environment variables:
- name: <ENV_VAR_NAME>
  valueFrom:
    secretKeyRef:
      name: <secretname>
      key: <secret-key>
*/}}
{{- define "get-secrets" -}}
{{- include "inject-javaopts-secret" . }}
{{- if .Values.newRelic.enabled -}}
{{- include "inject-newrelic-secret" . }}
{{- end }}
{{- range $key, $value := .Values.envVars -}}
{{- if (hasPrefix "${k8s_secret://" $value) }}
{{- $token := $value | replace  "${k8s_secret://" "" | replace "}" "" | splitn "/" 2 -}}
- name: {{ $key }}
  valueFrom:
    secretKeyRef:
      name: {{ $token._0 }}
      key: {{ $token._1 }}
{{ end }}
{{- end }}
{{- end -}}

{{/*
Parses .Values.envSecrets end creates kubernetes Secret with all values
that than is supposed to be mounted as secretRef environment vars in deployment
*/}}
{{- define "generate-env-secrets" -}}
apiVersion: v1
kind: Secret
metadata:
  name: {{ include "fullname" . }}
  labels:
    {{- include "labels" . | nindent 4 }}
type: Opaque
data:
{{- range $key, $value := .Values.envSecrets }}
  {{ $key }}: {{ $value | b64enc | quote }}
{{- end }}
{{- end }}

{{- define "ingress-hostname" -}}
{{ if .Values.ingress.hostname }}{{ .Values.ingress.hostname }}{{ else }}{{ include "fullname" . }}{{ end }}.{{ .Values.ingress.domain }}
{{- end -}}
