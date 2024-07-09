## Overview
Esse é um projeto simples feito para um caso de teste.

## Requisitos
* Java 17
* Gradle
* Docker compose

## Como rodar o projeto
1. Para rodar o projeto é apenas necessario o docker compose
2. "docker-compose up --build" e o projeto ira inicializar

## Endereços
1. Kafka WebUi(KafkaDrop) : http://localhost:19000
3. Api Consumer (Swagger): http://localhost:8080/swagger-ui/index.html

## Enviar mensagem para a fila
1 - Na side bar ir em: kafka>Topics.
2 - Em Topics ir em patient-topic
3 - clicar botão "Produce Message"
4 - na campo de texto "value" seguir o seguinte exemplo de payload:
```json
{
"code" : 1,
"name" : "name",
"cpf" : "cpf",
"birthDate" : "yyyy-mm-dd"
}
```
