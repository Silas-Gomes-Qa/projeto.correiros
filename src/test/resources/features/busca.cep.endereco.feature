#language: pt
#Author: silas.gomes@e2etreinamentos.com.br


@regressao @busca/endereco
Funcionalidade: Buscar endereco ou cep
  Como usuario 
  Quero buscar endereco ou cep
  Para obter inforacoes referentes aos dados consultado

  @positivo @cep
  Cenario: Buscar endereco por cep
    Dado que informo um cep valido
    Quando enviar o cep
    Entao valido os dados de endereco
    E retorno a tela para pesquisar pelo endereco

  @positivo @endereco
  Cenario: Buscar endereco por endereco
    Dado que informo um endereco valido
    Quando enviar o endereco
    Entao valido os dados de endereco
    E retorno a tela para pesquisar pelo bairro

    @negativo @vazio
    Cenario: Buscar endereco em branco
    Dado que não preencha o endereco ou cep
    Quando enviar o endereco
    Entao valido se direcionou para nova busca
    
    @negativo @cepinvalido
    Cenario: Buscar por cep invalido
    Dado que informe um cep invalido
    Quando enviar o endereco
    Entao valido dados nao encontrados