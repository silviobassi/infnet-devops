#!/bin/bash

# Verifica se o Helm está instalado
if ! command -v helm &> /dev/null
then
    echo "🚨 Helm não encontrado. Instalando..."

    # Instala o Helm (para Linux x86_64)
    curl https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3 | bash

    echo "✅ Helm instalado com sucesso em: $(which helm)"
else
    echo "✅ Helm já está instalado em: $(which helm)"
fi

# Adiciona repositório do Prometheus se ainda não estiver adicionado
if ! helm repo list | grep -q prometheus-community; then
    echo "📦 Adicionando repositório do Prometheus..."
    helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
else
    echo "📦 Repositório Prometheus-community já adicionado."
fi

helm status prometheus -n infnet-monitoring > /dev/null 2>&1
if [ $? -eq 0 ]; then
    echo "⚠️ Prometheus + Grafana já estão instalados e configurados no namespace 'infnet-monitoring'."
    echo "ℹ️ Se quiser reinstalar, use 'helm upgrade --force' ou delete o release com:"
    echo "   helm uninstall prometheus -n infnet-monitoring"
else
    echo "🚀 Instalando Prometheus + Grafana via Helm..."
    helm upgrade --install prometheus prometheus-community/kube-prometheus-stack \
      --namespace infnet-monitoring --create-namespace \
      --set grafana.persistence.enabled=true \
      --set grafana.persistence.size=5Gi \
      --set prometheus.server.persistentVolume.enabled=true \
      --set prometheus.server.persistentVolume.size=10Gi \
      --set grafana.service.type=LoadBalancer \
      --values values.yml
fi

