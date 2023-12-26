{{- define "gen-password" -}}
{{- $password := (lookup "v1" "Secret" .Release.Namespace .Release.Name) -}}
{{- if ($password) -}}
{{- range $key, $value := $password.data }}
  {{ $key }} : {{$value}}
  {{- end }}
{{- else }}
  rabbitmq-password: {{ randAlphaNum 10 | b64enc | quote }}
  rabbitmq-username: {{ .Values.username | b64enc | quote }}
{{- end }}
{{- end -}}

{{- define "ingress-hostname" -}}
{{ if .Values.ingress.hostname }}{{ .Values.ingress.hostname }}{{ else }}{{ include "fullname" . }}{{ end }}.{{ .Values.ingress.domain }}
{{- end -}}
