**# Projeto do Curso de Arquitetura de Software

## Disciplina: Integração Contínua, DevOps e Computação em Nuvem [25E1_3]

Acesso ao código fonte em: 

```text 
https://github.com/silviobassi/infnet-devops
```
### Passos para implementação e execução do projeto do projeto:

1. [ ] A imagem foi publicada no Docker Hub por meio de pipeline de CI/CD com GitHub Actions
2. [ ] Deploy local utilizando cluster Kubernetes - Minikube
3. [ ] Deployment da aplicação com 4 réplicas
4. [ ] A aplicação foi exposta para fora do cluster com service do tipo (LoadBalancer)
5. [ ] Criação de probes (Readiness e Liveness) para garantir a saúde da aplicação
6. [ ] Deployment de um banco de dados (MySql) com 1 réplica
7. [ ] O banco de dados ficou acessível com service do tipo (ClusterIP)
8. [ ] Deploy para monitoramento da aplicação com Grafana e Prometheus
9. [ ] O Grafana foi exposto para fora do cluster com service do tipo (LoadBalancer)
10. [ ] O Grafana foi configurado para coletar métricas do Prometheus
11. [ ] O Prometheus ficou acessível com service do tipo (ClusterIP)
12. [ ] Um PVC foi utilizado para escrever os dados do Prometheus de forma persistente
13. [ ] Dashboards do Grafana para exposição de dados sensíveis (memória, cpu, ...)
14. [ ] Stress Test da aplicação com Fortio

#### Demonstração do projeto

1. Pipeline de CI/CD com GitHub Actions

Código fonte em: `.github/workflows/deploy.yml`


