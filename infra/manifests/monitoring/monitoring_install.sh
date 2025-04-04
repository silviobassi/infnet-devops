#!/bin/bash

helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update

helm upgrade --install prometheus prometheus-community/kube-prometheus-stack \
  --namespace infnet-monitoring --create-namespace \
  --set grafana.persistence.enabled=true \
  --set grafana.persistence.size=5Gi \
  --set prometheus.server.persistentVolume.enabled=true \
  --set prometheus.server.persistentVolume.size=10Gi \
  --set grafana.service.type=LoadBalancer \
  --values values.yml