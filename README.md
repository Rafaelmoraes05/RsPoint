# RSPoint - Sistema de Ponto

![Java](https://img.shields.io/badge/Java-21-blue?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4-brightgreen?style=for-the-badge&logo=spring)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange?style=for-the-badge&logo=mysql)

## 📌 Sobre o Projeto

**RSPoint** é uma API REST para gestão de controle de ponto em um ambiente comercial. O sistema permite:

- Cadastro de funcionários
- Registro de ponto com data, horário e geolocalização
- Cálculo automático de horas trabalhadas e horas extras

## 🛠️ Diagrama de Classes

```mermaid
classDiagram
    class Funcionario {
        +int id
        +String nome
        +String cpf
        +String email
        +String cargo
        +Date dataAdmissao
        +StatusFuncionario status
    }

    class RegistroPonto {
        +int id
        +DateTime dataRegistro
        +TipoRegistro tipoRegistro
        +Decimal latitude
        +Decimal longitude
    }

    class FolhaPonto {
        +int id
        +int mes
        +int ano
        +Decimal totalHorasTrabalhadas
        +Decimal totalHorasExtras
    }

    class StatusFuncionario {
        <<enumeration>>
        ATIVO
        INATIVO
    }

    class TipoRegistro {
        <<enumeration>>
        ENTRADA
        SAIDA
    }

    Funcionario "1" -- "0..*" RegistroPonto : possui
    Funcionario "1" -- "0..*" FolhaPonto : possui


