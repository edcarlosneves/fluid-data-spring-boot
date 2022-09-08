# Fluid Data

## Proposta

Esta aplicação tem como objetivo armazenar dados de fluidos para cálculos termodinâmicos (esses cálculos serão feitos em outro serviço: um aws lambda em Python que vai usar a biblioteca CoolProp)

## Ferramentas/Tecnologias Utilizadas

Java
Spring Boot
Docker
Docker Compose
PostgreSQL

## Como executar o projeto localmente

Para executar esse projeto, é necessário ter o Docker + Docker Compose instalados na máquina. Instruções aqui: https://docs.docker.com/engine/install/

Também é recomendado ter o make instalado na máquina para a execução do comando do arquivo Makefile. Para instalar no ubuntu e derivados, siga o seguinte passo:

```
sudo apt update
sudo apt install make
```

Agora vamos executar o sistema localmente:

- Clone o respositório

```
git clone https://github.com/edcarlosneves/fluid-data-spring-boot
```

- Entre na pasta fluid-data-spring-boot
```
cd fluid-data-spring-boot
```

- Suba o banco de dados
```
make database-up
```

- Rode a aplicação
```
make run-api
```

A partir deste ponto sua aplicação está rodando na porta `8080` para validar, siga a documentação do endpoints abaixo.

## Endpoints da API
- Obter todos os dados dos fluidos cadastrados

```
GET /fluid-data
Retorna:
{
    "content": [
        {
            "id": "55f80de1-feb6-488a-a175-3728a6cbe305",
            "fluidTemperature": 25.0,
            "fluidPressure": 101000.0,
            "fluidName": "Water"
        }
    ],
    "pageable": {
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 10,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 1,
    "last": true,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}
```
- Criar um novo fluido
```
POST /fluid-data
Body:
{
    "fluidName": "Water",
    "fluidTemperature": 25,
    "fluidPressure": 101000
}
Retorna:
{
    "id": "b1bcf569-83d3-4fac-90ef-85fd669f9314",
    "fluidTemperature": 25.0,
    "fluidPressure": 101000.0,
    "fluidName": "Water"
}
```