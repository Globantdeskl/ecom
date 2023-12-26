# RABBITMQ CHART

Helm chart deploys RabbitMQ with DeploymentSet with scale 1.
Exposes:

## Usage

```bash
helm install --namespace <namespace> <release_name> <path_to_helm_chart>
```

Example:

```bash
helm install --namespace dev rabbit-dev rabbit
```

## Exposes

- Service: <RELEASE_NAME>. Ports: 5672 - for clients, 15672 - management interface
- Secret: <RELEASE_NAME>. Fields: `rabbitmq-username` and `rabbitmq-password`
