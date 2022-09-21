# Payment

## Descrição Geral

Projeto inspirado em uma atividade da aula 162 do curso [Java COMPLETO Programação Orientada a Objetos +Projetos
](https://www.udemy.com/course/java-curso-completo/), ministrado pelo professor Nélio Alves.

<p>Este projeto foi adaptado construindo uma api, com o intuito de estudo do framework Spring Boot.</p>

### Descrição do projeto:

<p>
Uma empresa possui funcionários próprios e terceirizados. Para cada funcionário, deseja-se registrar nome, horas trabalhadas e valor por hora.
</p>
<p>
Funcionários terceirizado possuem ainda uma despesa adicional. O pagamento dos funcionários corresponde ao valor da hora multiplicado pelas horas trabalhadas, sendo que os funcionários terceirizados ainda recebem um bônus correspondente a 110% de sua despesa adicional.
</p>

O projeto consiste em fazer uma api com todas as relações **CRUD** e também satisfazer a problemática acima.

### EndPoints do projeto:
- Cadastro de Funcionários: /register
- Cadastro de Funcionários Terceirizados: /register/outSourced
- Atualizar Funcionário: /update
- Atualizar Funcionário Terceirizado: /update/outSourced
- Listar Todos os Funcionários: /listAll
- Remover funcionário: /remove/{id}
- Salário e atributo de todos os funcionários: /salary