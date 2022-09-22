# Payment

## Descrição Geral

Projeto inspirado em uma atividade da aula 162 do curso [Java COMPLETO Programação Orientada a Objetos +Projetos
](https://www.udemy.com/course/java-curso-completo/), ministrado pelo professor Nélio Alves. Deploy [api_payment](https://api-paymen.herokuapp.com/).

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

### Descrição da Api
#### Executar Api Remotamente:
- Link do Deploy: https://api-paymen.herokuapp.com/

#### Executar Api localmente:
- Para clonar o projeto: git clone https://github.com/TaylanTorres09/Payment.git
- Para Executar o projeto precisasse:
    - Java [JDK](https://www.oracle.com/java/technologies/downloads/#java17). Este projeto está usando a versão 17.
    - Banco [MySql](https://www.mysql.com/), também pode-se utilizar o online segue tutorial do canal [Automation Step by Step](https://www.youtube.com/c/AutomationStepByStep): [Link](https://www.youtube.com/watch?v=TMGHOW8Hzvw) Plano grátis com 5mb.

- Extensões do vscode utilizadas:
    - [Debugger for Java](https://marketplace.visualstudio.com/items?itemName=redhat.java)
    - [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack)
    - [Lombok Annotations Support for VS Code](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-lombok)

- Configurar variáveis do Banco de Dados.

![Banco de Dados](https://drive.google.com/file/d/1VYkcIN2g5kPf3c7DBhGkdfprtMCRRnmZ/view?usp=sharing)

- Na pasta src/main, execute o arquivo PaymentApplication.java

![PaymentApplication](https://drive.google.com/file/d/1b_ie7_9Om0PtDrhIMF2J_HJFsT45Dt-f/view?usp=sharing)

- Para testar a api você pode utilizar ferramentas de client como:
    - [Postman](https://www.postman.com/)
    - [Insomnia](https://insomnia.rest/download)
    - Extensão do VsCode [Thunder Client](https://marketplace.visualstudio.com/items?itemName=rangav.vscode-thunder-client)
    - Ou outra de sua preferência.

### Próximos Passos
- Adicionar autenticação | cadastro de usuário da api.
- Ainda no cadastro fazer verificação por email com geração de código de validação | serviços de mensageria.
- Contruir uma interface gráfica para a api | FrontEnd.