#language:pt
@filmes
Funcionalidade: CRUD Filme

  #O Contexto foi criado,porque todos os cenários estão utilizando
  Contexto:
    Dado que tenha realizado o login com dados validos
    E que tenha um payload valido da API de Filme

  @cadastroFilme
  Cenario: Cadastro Filme
    Quando realizo uma requisicao do tipo POST de Filme
    Entao valido que recebo status 201 no response
    E valido que no campo "categorias.tipo[1]" possui o valor "Comedia"
    E armazeno o id que recebo do response de Filme

  @consultaFilme
  Cenario: Consulta Filme
    Quando realizo uma requisicao do tipo GET de Filme atraves do nome
    Entao valido que recebo status 200 no response
    E valido que no campo "categorias[0].tipo[1]" possui o valor "Comedia"

  @alterarFilme
  Cenario: Alteracao Filme
    E altero o indice 1 da lista de categoria de filem com os valores
      |tipo|Terror|
    Quando realizo uma requisicao do tipo PUT de Filme
    Entao valido que recebo status 200 no response
    E valido que no campo "categorias.tipo[1]" possui o valor "Terror"

  @consultaFilmeAlterado
  Cenario: Consulta Filme Alterado
    Quando realizo uma requisicao do tipo GET de Filme atraves do nome
    Entao valido que recebo status 200 no response
    E valido que no campo "categorias[0].tipo[1]" possui o valor "Terror"

  @filmeExcluido
  Cenario: Exclusao Filme
    Quando realizo uma requisicao do tipo DELETE de Filme
    Entao valido que recebo status 200 no response

  @consultaFilmeExclusao
  Cenario: Consulta Filme Exclusao
    Quando realizo uma requisicao do tipo GET de Filme atraves do nome
    Entao valido que recebo status 200 no response
    E valido que recebo uma lista vazia no response