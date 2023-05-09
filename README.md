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

Este projeto utiliza a rota local http://localhost:8080  e utiliza como forntend o repositório [REST-API-EmpresaFinanceira-FrontEnd](https://github.com/joaorafaelleite/REST-API-EmpresaFinanceira-FrontEnd).

## Tecnologias

- [Java](https://www.java.com/pt-BR/)(Versão 17)- Linguagem de programação
- [Maven](https://maven.apache.org/) - Ferramente da automação de compilação
- [Spring](https://spring.io/) - Framework open source para a plataforma Java
- [H2 Database](https://www.h2database.com/html/main.html) - Banco de dados relacional escrito em Java que funciona em memória.
- [Eclipse](https://eclipseide.org/) - IDE para desenvolvimento
- [Postman](https://www.postman.com/) - Plataforma para teste de API

## Endpoints
###Clientes
<table class="table table-striped table-bordered mt-2">
  <thead>
    <tr>
      <th scope="col" class="text-center"> Método </th>
        <tbody>
          <tr>
            <th scope="row" class="text-center"> GET </th>
            <td class="text-center"> GET </td>
            <td class="text-center"> POST </td>
            <td class="text-center"> PUT </td>
            <td class="text-center"> DELETE </td>
          </tr>
        </tbody>
      <th scope="col" class="text-center"> Endpoint </th>
        <tbody>
          <tr>
            <th scope="row" class="text-center"> "/api/v1/clientes"	</th>
            <td class="text-center"> "/api/v1/clientes/{cpf}"	</td>
            <td class="text-center"> "/api/v1/clientes"</td>
            <td class="text-center"> "/api/v1/clientes/{cpf}"	</td>
            <td class="text-center"> "/api/v1/clientes/{cpf}" </td>
          </tr>
      </tbody>
      <th scope="col" class="text-center"> Descrição </th>
        <tbody>
          <tr>
            <th scope="row" class="text-center"> Retorna todos os clientes cadastrados </th>
            <td class="text-center"> Retorna o cliente com o cpf informado </td>
            <td class="text-center"> Cadastra um novo cliente </td>
            <td class="text-center"> Atualiza o cliente com o cpf informado </td>
            <td class="text-center"> Deleta o cliente com o cpf informado </td>
          </tr>
        </tbody>
    </tr>
  </thead>
  
Ao atualizar um cliente (PUT), os campos que não forem informados serão mantidos.

Empréstimos
Método	Endpoint	Descrição
GET	"/api/v1/clientes/{cpf}/emprestimos	Retorna todos os empréstimos do cliente com o cpf informado
GET	"/api/v1/clientes/{cpf}/emprestimos/{id}"	Retorna o empréstimo do cliente com o cpf informado e o id informado
POST	"/api/v1/clientes/{cpf}/emprestimos"	Cadastra um novo empréstimo para o cliente com o cpf informado
DELETE	"/api/v1/clientes/{cpf}/emprestimos/{id}"	Deleta o empréstimo do cliente com o cpf informado e o id informado

/home
- Página em construção, atualmente apresenta as tecnologias utilizadas tanto no Backend como no Frontend
- Também pode ser acessada pela rota em branco ou ao clicar em 'SofieBank'

/clientes
- Exibe, em formato de tabela, a lista de clientes cadastrados.

/clientes/cadastrar
- Permite cadastrar um novo cliente na base de dados.

/clientes/editar/:cpf
- Permite alterar um cliente já cadastrado na base de dados.

# Validações 

- O campo CPF deve, obrigatóriamente, conter um CPF válido.
- O campo Telefone deve conter apenas números, sendo preenchico com DDD e Telefone, com 10 ou 11 dígitos.
- O campo CEP deve conter apenas números e possuir 8 dígitos.
- Todos os campos devem estar preenchidos para dar sequência.
- Não é permitida a alteração do CPF de um cliente já cadastrado.

## Informações de Contato

  Caso tenha alguma dúvida, sugestão ou crítica, entre em contato pelo [email](joaorafael.leite@hotmail.com) ou pelo [LinkedIn](https://www.linkedin.com/in/joao-rafael-leite/).
