#!/bin/bash
# This script is used to build a docker image, push it to Docker Hub, and deploy the application to a Kubernetes cluster.
# build docker image
docker build -t silviobassi/app-course:1.0.0 .

# login docker
docker login -u silviobassi -p "$DOCKER_PASSWORD"

# push docker image
docker push silviobassi/app-course:1.0.0

# deploy app

kubectl create namespace infnet-app
kubectl apply -f manifests/k8s/mysql-deployment.yaml
kubectl apply -f manifests/k8s/app-deployment.yaml

helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update

helm upgrade --install prometheus prometheus-community/kube-prometheus-stack \
  --namespace infnet-monitoring --create-namespace \
  --set grafana.persistence.enabled=true \
  --set grafana.persistence.size=5Gi \
  --set prometheus.server.persistentVolume.enabled=true \
  --set prometheus.server.persistentVolume.size=10Gi \
  --set grafana.service.type=LoadBalancer \
  --values manifests/monitoring/values.yml