##  Lojinha API automação

Esse é um repositório que contém a automação de alguns Testes de API Rest de um software denominado Lojinha.
Os sub-tópico abaixo descrevem algumas decisões tomada na estruturação utilizada no projeto.


> **Note:** The **Publish now** button is disabled if your file has not been published yet.

## Tecnologias Utilizadas

- Java: https://www.oracle.com/br/java/technologies/downloads/
- Junit: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
- RestAssured: https://mvnrepository.com/artifact/io.rest-assured/rest-assured/5.3.0

- Maven: https://maven.apache.org/


## Testes Automatizados

- Testes para validar as partições de equivalências ao valos do produto na aplicação Lojinha, que estão vinculada diretamente a regra de negócio que diz que o valor do produto deve esta entre "R$ 0,01 a R$ 7.000,00"





### Notas Gerais

- Na execução dos testes, foi utilizado a anotação "Before Each", para capturar o token que será utilizado posteriormente nos métodos de testes.
- Armazenamos os dados que são enviados para API, através do uso de classes Pojo.
- Os dados iniciais foram criados através do uso da classe "Data Factores".
- Nesse projeto utilizamos o uso do "JUnit 5", possibilizando o uso da anotação "@DisplayName", descrevendo os testes em português. 
