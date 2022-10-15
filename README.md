<p align="center">
 <img src="https://github.com/jsantos-examples/flexpag-desafio-backend/blob/main/contents/flexpag.png" width="600" alt="Banner Flexpag">
</p>

# 🚀 flexpag desafio backend

Bem-vindo(a).

Olá, como vai?! Meu nome é [Giovana](https://github.com/giiiors) e estou participando do processo seletivo da [Flexpag](https://flexpag.com).
Venho por meio deste repositorio entregar a aplicação `back-end` do desafio. Espero que você goste!

> <b>Status code:</b> Finalizado!💙🚀

<br>

## ℹ index

-   [🧠 contexto](#-contexto)
  - [rotas](#-rotas-implementadas)
-   [📥 download](#-download)
  -   [setup](#-setup)
  -   [starting](#-starting)
-   [🛠 tecnologias](#-tecnologias)
-   [✍🏼 autora](#-autora)

## 🧠 contexto
A Flexpag é uma empresa de tecnologia especializada em soluções digitais de agendamento. Sabendo disso, montamos um desafio que consiste em implementar um serviço de agendamento agendando.

### 🚰 Fluxo esperado

- Quando um agendamento é enviado deve ser registrado como `pending` e retornado o id;
- O usuário deve conseguir consultar o status do agendamento `pending`|`paid`;
- :warning: **Se o agendamento ainda não foi realizado o usuário pode**;
  - Excluir o agendamento;
  - Atualizar a data:hora do agendamento;

### 🔁 Rotas implementadas

| Request     | Endpoint                                  | Descrição                  |
| ------------|-------------------------------------------|----------------------------|
|  `POST`     | http://localhost:8080/agendamento         | cadastrar agendamento      |
|  `PUT`      | http://localhost:8080/agendamento/{id}    | atualizar agendamento      |
|  `DELETE`   | http://localhost:8080/agendamento/{id}    | deletar agendamento        |
|  `GET`      | http://localhost:8080/status/{id}         | consultar status pagamento |
|  `PATCH`    | http://localhost:8080/pagamento/{id}      | pagar boleto               |

<br>

### 📄 Formato de envio Json

```json
{
  "usuario": "String",
  "dataAgendamento": "dd/MM/yyyy",
  "valor": "Double",
  "horaAgendamento": "HH:mm"
}
```

<br>

## 📥 download

Antes de começar, você precisará ter as seguintes ferramentas instaladas em sua máquina:
[Git](https://git-scm.com), [JDK11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) este projeto usa o java **_11_**. Além disso, é bom ter um editor para trabalhar com código como [Intelij](https://www.jetbrains.com/idea/)  .

### 💻 setup

```php
# clonar este repositório
$ git clone https://github.com/giiiors/flexpag-desafio-backend.git

# acesse a pasta do projeto
$ cd flexpag-desafio-backend

# instale as dependências
$ ./mvnw install
```

### ⚙ aplication.yaml foi configurado para o banco local h2

```yaml
spring:
  datasource:
    driverClassName: org.h2.Driver
    url: jdbc:h2:mem:payment-scheduler
    username: admin
    password: admin
  h2:
    console:
      enabled: true
      path: /h2-console
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        format_sql: true
        show_sql: true
```
<br>

## ▶ starting

```php
# executando o comando
$ ./mvnw spring-boot:run

# aplicação iniciará em <http://localhost:8080/>
```

<br>

## 🛠 tecnologias

As seguintes ferramentas/tecnologias foram usadas na construção e teste do projeto. Ao clicar no ícone da tecnologia, você será redirecionado ao site oficial para instalação:

<br>

|                                   logo                                     |                       Framework                       | Version  |
| :------------------------------------------------------------------------: |:-----------------------------------------------------:|:--------:|
| <img height="35" width="40" src="https://skillicons.dev/icons?i=idea">     |     [Intelij](https://www.jetbrains.com/idea/)        |  `2022`  |
| <img height="35" width="40" src="https://skillicons.dev/icons?i=java">     |          [Java](https://www.java.com/pt-BR/)          | `11.0.0` |
| <img height="35" width="40" src="https://skillicons.dev/icons?i=spring">   |        [SpringBoot](https://start.spring.io/)         | `2.7.2`  |
| <img height="35" width="40" src="https://skillicons.dev/icons?i=maven">    |           [Maven](https://maven.apache.org)           | `4.0.0`  |

<br>

## ✍🏼 autora

<table>
  <tr>
   <tr align=center>
        <th><a href="https://github.com/giiiors"><strong> Giovana Ferraz </strong><a></th>
  </tr>
    <td align="center">
      <a href="https://github.com/giiiors">
        <img src="https://user-images.githubusercontent.com/82064724/195905179-ebf7e6ba-ff00-4245-bbb6-075b6a7b4858.jpg" height="110" width="110"/></a><br>
        <sub>
            <a href="https://www.linkedin.com/in/giovana-ferraz-737623162/" target="_blank" rel="noreferrer" rel="noopener">
              <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin"/>
            </a></br>
          </div>
        </sub>
    </td>
</table>

<br>

[[ ↑ voltar ]](#-flexpag-desafio-backend)
