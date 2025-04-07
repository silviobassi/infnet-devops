# Projeto do Curso de Arquitetura de Software

## Disciplina: Integração Contínua, DevOps e Computação em Nuvem [25E1_3]

Acesso ao repositório em:
[https://github.com/silviobassi/infnet-devops](https://github.com/silviobassi/infnet-devops.git)


### Passos para Implementação e Execução do Projeto:

1. [x] A imagem foi publicada no Docker Hub por meio de pipeline de CI/CD com GitHub Actions
2. [x] Deploy local utilizando cluster Kubernetes - Minikube
3. [x] Deployment da aplicação com 4 réplicas
4. [x] A aplicação foi exposta para fora do cluster com service do tipo (LoadBalancer)
5. [x] Criação de probes (Readiness e Liveness) para garantir a saúde da aplicação
6. [x] Deployment de um banco de dados (MySql) com 1 réplica
7. [x] O banco de dados ficou acessível com service do tipo (ClusterIP)
8. [x] Deploy para monitoramento da aplicação com Grafana e Prometheus
9. [x] O Grafana foi exposto para fora do cluster com service do tipo (LoadBalancer)
10. [x] O Grafana foi configurado para coletar métricas do Prometheus
11. [x] O Prometheus ficou acessível com service do tipo (ClusterIP)
12. [x] Um PVC foi utilizado para escrever os dados do Prometheus de forma persistente
13. [x] Dashboards do Grafana para exposição de dados sensíveis (memória, cpu, ...)
14. [x] Stress Test da aplicação com Fortio

## 1. Código Fonte e Configurações do Projeto

### 1.1. Pipeline de CI/CD com GitHub Actions - Acesse em 👇

- [.github/workflows/deploy.yml](https://github.com/silviobassi/infnet-devops/blob/main/.github/workflows/deploy.yml)

### 1.2. Manifestos e Configurações da Aplicação - Acesse em 👇

- [infra/manifests/k8s/app-deployment.yml](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/k8s/app-deployment.yml)<br>
- [infra/manifests/k8s/app-service.yml](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/k8s/app-service.yml)<br>
- [infra/manifests/k8s/mysql-config.yml](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/k8s/mysql-config.yml)<br>
- [infra/manifests/k8s/mysql-deployment.yml](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/k8s/mysql-deployment.yml)<br>
- [infra/manifests/k8s/mysql-service.yml](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/k8s/mysql-service.yml)<br>

### 1.3. Manifestos e Configurações do Grafana e Prometheus - Acesse em 👇

- [infra/manifests/monitoring/monitoring_install.sh](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/monitoring/monitoring_install.sh)<br>
- [infra/manifests/monitoring/prometheus-config.yml](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/monitoring/prometheus-config.yml)<br>
- [infra/manifests/monitoring/values.yml](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/monitoring/values.yml)<br>


## 2. Execução do Projeto

### 2.1. Instalação do Docker, Kubectl e Minikube (Se não tiver instalados):

- [Instalação do Docker](https://docs.docker.com/engine/install/)
- [Instalação do Kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/)
- [Instalação do Minikube](https://minikube.sigs.k8s.io/docs/start/?arch=%2Flinux%2Fx86-64%2Fstable%2Fbinary+download)

### 2.2 Execução do Deploy do Projeto:

- Clone o repositório em sua máquina:

```bash
git clone https://github.com/silviobassi/infnet-devops.git
```

- ⚠️ No diretório do projeto, execute os comandos 👇

```bash
# Executa o deploy da aplicação (App e MySQL)
minikube start --driver=docker 
cd infra/manifests/k8s
kubectl apply -f app-namespace.yml
kubectl apply -f .

# Executa o deploy do monitoramento (Grafana e Prometheus)
cd ../monitoring
sh monitoring_install.sh
```

## 3. Demonstração do Projeto em Execução:

### 3.1. Pipeline de CI/CD com GitHub Actions em Execução:

Pipeline de geração de imagem da aplicação

![Pipeline](devops-validate/workflow_pipeline_in_action.png)

### 3.2. Aplicação em Execução:

Deployment aplicado e exibição de pods, services e url para acesso a API da aplicação

![App](devops-validate/app_in_execution_terminal.png)

Swagger para acesso a API da aplicação

![App](devops-validate/app_in_execution_browser.png)

### 3.3. Monitoramento em Execução:

Deployment aplicado

![Grafana](devops-validate/applied_deploy_monitoring.png)

Exibição de pods, services e pvc do monitoramento

![Grafana](devops-validate/monitoring_pod_svc_pvc_in_action.png)