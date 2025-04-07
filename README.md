# Projeto do Curso de Arquitetura de Software

## Disciplina: Integração Contínua, DevOps e Computação em Nuvem [25E1_3]

Acesso ao repositório em:
[https://github.com/silviobassi/infnet-devops](https://github.com/silviobassi/infnet-devops.git)


### Passos para implementação e execução do projeto do projeto:

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

#### Código Fonte e Configurações do Projeto

##### 1. Pipeline de CI/CD com GitHub Actions - Acesse em 👇

- [.github/workflows/deploy.yml](https://github.com/silviobassi/infnet-devops/blob/main/.github/workflows/deploy.yml)

##### 2. Manifestos e configurações da aplicação - Acesse em 👇

- [infra/manifests/k8s/app-deployment.yml](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/k8s/app-deployment.yml)<br>
- [infra/manifests/k8s/app-service.yml](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/k8s/app-service.yml)<br>
- [infra/manifests/k8s/mysql-config.yml](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/k8s/mysql-config.yml)<br>
- [infra/manifests/k8s/mysql-deployment.yml](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/k8s/mysql-deployment.yml)<br>
- [infra/manifests/k8s/mysql-service.yml](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/k8s/mysql-service.yml)<br>

##### 2. Manifestos e configurações do grafana e prometheus - Acesse em 👇

- [infra/manifests/monitoring/monitoring_install.sh](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/monitoring/monitoring_install.sh)<br>
- [infra/manifests/monitoring/prometheus-config.yml](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/monitoring/prometheus-config.yml)<br>
- [infra/manifests/monitoring/values.yml](https://github.com/silviobassi/infnet-devops/tree/main/infra/manifests/monitoring/values.yml)<br>


#### Execução do Projeto

##### 1. Instalação do Minikube:

Observação: **⚠️ Tenha o Docker e o Kubectl instalados na sua máquina. ⚠️**

```bash
curl -LO https://github.com/kubernetes/minikube/releases/latest/download/minikube-linux-amd64
sudo install minikube-linux-amd64 /usr/local/bin/minikube && rm minikube-linux-amd64
```

##### 2. Execução do deploy do projeto:

Observação: **⚠️ Esteja no diretório do projeto! ⚠️**

###### 2.1. Execute o deploy da aplicação (App e MySQL:

```bash
minikube start --driver=docker 
cd infra/manifests/k8s
kubectl apply -f app-namespace.yml
kubectl apply -f .
```
###### 2.2. Execute o deploy do monitoramento (Grafana e Prometheus):

```bash
cd infra/manifests/monitoring
sh monitoring_install.sh
```