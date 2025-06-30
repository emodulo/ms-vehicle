# ms-vehicle

O `ms-vehicle` é o microserviço responsável pelo gerenciamento de veículos na plataforma ShopCar. Ele permite o cadastro, consulta, listagem e marcação de veículos como vendidos, mantendo a integridade das informações para as etapas de venda.

## Funcionalidades

- Cadastro de veículos com suas características
- Consulta e listagem com filtros e ordenações
- Marcação de veículos como vendidos
- Exposição via API REST com suporte a paginação e ordenação

## Arquitetura

Este serviço foi desenvolvido com:

- **Spring Boot** com arquitetura **Hexagonal (Ports and Adapters)**
- Banco de dados **PostgreSQL**
- Organização por domínios (`vehicle`, `make`, `model`, etc.)
- Implantação via **Kubernetes** com suporte a HPA, ConfigMap, Secrets, Ingress
- CI/CD com **GitHub Actions**

## Estrutura do Banco de Dados

Banco: `eModulo` (PostgreSQL)

Entidades principais:

- `Vehicle`: dados gerais do veículo
- `Make`: fabricante
- `Model`: modelo
- `Version`, `Color`, `BodyType`, `Transmission`: características específicas

Relacionamentos com chave estrangeira entre entidades.

## Autenticação

O `ms-vehicle` não requer autenticação para manipulação dos endpoints.

## Endpoints Disponíveis

| Método | Rota                             | Descrição                                      |
|--------|-----------------------------------|-----------------------------------------------|
| POST   | `/api/v1/vehicles`               | Cadastra um novo veículo                       |
| GET    | `/api/v1/vehicles`               | Lista veículos com filtros                     |
| GET    | `/api/v1/vehicles/{id}`          | Consulta veículo por ID                        |
| PUT    | `/api/v1/vehicles/{id}/sell`     | Marca o veículo como vendido                   |

Para acessar a documentação da api localmente, acessar o endpoint: http://localhost:8082/swagger-ui/index.html

## Kubernetes

O serviço está preparado para rodar em Kubernetes com os seguintes recursos:

- `Deployment` com readiness/liveness probe
- `Service` tipo `ClusterIP`
- `HorizontalPodAutoscaler` com 75% de CPU e memória
- `ConfigMap` para variáveis não sensíveis
- `Secret` para senhas e dados sigilosos
- `Ingress` configurado para roteamento HTTP

## Como instalar via Docker (modo local)

> Repositório de infraestrutura: [`emodulo/shopcar-infra`](https://github.com/emodulo/shopcar-infra)

```powershell
powershell -ExecutionPolicy Bypass -File shopcar-via-docker.ps1
```

## Como instalar via Kubernetes (modo cluster)

```powershell
powershell -ExecutionPolicy Bypass -File shopcar-via-kubernetes.ps1
```

---

## Tecnologias utilizadas

- Java 21
- Spring Boot
- PostgreSQL
- Kubernetes (YAML)
- GitHub Actions
- Docker & Docker Compose

---

## Estrutura do Projeto

```
ms-vehicle/
├── domain/
├── application/
├── adapter-in/
├── adapter-out/
├── port-in/
├── port-out/
├── config/
└── kubernetes/
```

---

## Contribuidores

- Kreverson Silva – Arquiteto e Desenvolvedor Principal