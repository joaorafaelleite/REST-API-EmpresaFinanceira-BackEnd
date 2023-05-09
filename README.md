# Bem-vindo ao meu repositório REST-API-EmpresaFinanceira-BackEnd

## Descrição

Esse projeto foi gerado com [Spring Initializr](https://start.spring.io/)

### Funcionalidades

:green_circle: Status: Operando
- Cadastro de clientes
- Consulta individual e coletiva de clientes
- Edição de clientes
- Exclusão de clientes

:yellow_circle: Status: Em manutenção
- Cadastro de emprestimos
- Consulta individual e coletiva de emprestimos
- Exclusão de emprestimos

Este projeto utiliza a rota local http://localhost:8080  e tem como forntend o repositório [REST-API-EmpresaFinanceira-FrontEnd](https://github.com/joaorafaelleite/REST-API-EmpresaFinanceira-FrontEnd).

## Tecnologias

- [Java](https://www.java.com/pt-BR/) (Versão 17) - Linguagem de programação
- [Maven](https://maven.apache.org/) - Ferramente da automação de compilação
- [Spring](https://spring.io/) - Framework open source para a plataforma Java
- [H2 Database](https://www.h2database.com/html/main.html) - Banco de dados relacional escrito em Java que funciona em memória.
- [Eclipse](https://eclipseide.org/) - IDE para desenvolvimento
- [Postman](https://www.postman.com/) - Plataforma para teste de API

## Endpoints

### Clientes

<table>
  <thead>
    <tr>
      <th align="center"> Método </th>
      <th align="center"> Endpoint </th>
      <th align="center"> Descrição </th> 
    </tr>
  </thead>
  <tbody align="left">
    <tr>
      <td>GET</td>
      <td>"/api/v1/financeira/clientes"</td>
      <td>Retorna todos os clientes cadastrados</td>
    </tr>
    <tr>
       <td>GET</td>
       <td>"/api/v1/financeira/clientes/{cpf}"</td>
       <td>Retorna o cliente com o cpf informado</td>
    </tr>
    <tr>
       <td>POST</td>
       <td>"/api/v1/financeira/clientes"</td>
       <td>Cadastra um novo cliente</td>
    </tr>
    <tr>
       <td>PUT</td>
       <td>"/api/v1/financeira/clientes/{cpf}"</td>
       <td>Atualiza o cliente com o cpf informado</td>
    </tr>
    <tr>
       <td>DELETE</td>
       <td>"/api/v1/financeira/clientes/{cpf}"</td>
       <td>Deleta o cliente com o cpf informado</td>
    </tr>
  </tbody>
</table>

### Emprestimos

<table>
  <thead>
    <tr>
      <th align="center"> Método </th>
      <th align="center"> Endpoint </th>
      <th align="center"> Descrição </th> 
    </tr>
  </thead>
  <tbody align="left">
    <tr>
      <td>GET</td>
      <td>"/api/v1/financeira/clientes/{cpf}/emprestimos</td>
      <td>Retorna todos os empréstimos do cliente com o cpf informado</td>
    </tr>
    <tr>
       <td>GET</td>
       <td>""/api/v1/financeira/clientes/{cpf}/emprestimos/{id}"</td>
       <td>Retorna o empréstimo do cliente com o cpf informado e o id informado</td>
    </tr>
    <tr>
       <td>POST</td>
       <td>"/api/v1/financeira/clientes/{cpf}/emprestimos"</td>
       <td>Cadastra um novo empréstimo para o cliente com o cpf informado</td>
    </tr>
    <tr>
       <td>DELETE</td>
       <td>"/api/v1/financeira/clientes/{cpf}/emprestimos/{id}"</td>
       <td>Deleta o empréstimo do cliente com o cpf informado e o id informado</td>
    </tr>
  </tbody>
</table>

# Validações 
  ## Clientes
- O campo CPF deve, obrigatóriamente, conter um CPF válido.
- O campo Telefone deve conter apenas números, sendo preenchico com DDD e Telefone, com 10 ou 11 dígitos.
- O campo CEP deve conter apenas números e possuir 8 dígitos.
- Não é permitida a alteração do CPF de um cliente já cadastrado.
- Ao atualizar um cliente (PUT), os campos que não forem informados serão mantidos.
- Todos os campos devem estar preenchidos no momento do cadastro (POST).
## Emprestimos
- As datas devem ser passadas no formato "yyyy-MM-dd".
- Empréstimos na categoria "BRONZE" terão um valor final igual ao seu valor inicial mais 80%.
- Empréstimos na categoria "PRATA" serão subdivididos em duas categorias:
  - PRATA  para os emprestimos cujo valor inical for menor ou igual a R$ 5000,00 esses terão um valor final igual ao seu valor inicial mais 60%.
  - PRATAII para emprestimos cujo valor inicial for maior que R$ 5000,00 esses terão um valor final igual ao seu valor inicial mais 40%.
- Empréstimos na categoria "OURO" erão subdivididos em duas categorias:
  - OURO  para os emprestimos em que o cliente possua até 1 emprestimo, esses terão um valor final igual ao seu valor inicial mais 20%.
  - OUROII para os emprestimos em que o cliente possua mais de 1 emprestimo, esses terão um valor final igual ao seu valor inicial mais 30%.
- Um cliente só pode receber um novo empréstimo se o valor inicial de todos os seus empréstimos existentes mais o valor pleiteado, for menores ou igual a 10x o seu rendimento mensal.
- Todos os campos devem estar preenchidos no momento do cadastro (POST).

## Autor

<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/112492208?s=400&u=d9c75b76dd2b8ebed82d5b37ac031c6da8600948&v=4" width="100px;" alt=""/>

Feito por João Rafael 👋🏽 Entre em contato!

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/joao-rafael-leite/)
[![Microsoft Outlook](https://img.shields.io/badge/Microsoft_Outlook-0078D4?style=for-the-badge&logo=microsoft-outlook&logoColor=whitem)](mailto:joaorafael.leite@hotmail.com)
