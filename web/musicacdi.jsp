<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="aux" tagdir="/WEB-INF/tags/" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CADASTRO MUSICA</title>
        <script src='resources/js/jquery.min.js'></script>
        <script src='resources/js/bootstrap.min.js'></script>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Formulário de Musica:</h1>       

        <div class="container">
            <form method="POST" action="musicacdi">
                <input name="id" type="hidden" value="${musica.id}"/>
                <div class="form-group">
                    <label id="labelNome" for="nome">Nome:</label>
                    <input id="nome" class="form-control" name="nome" type="text" required  value="${musica.nome}"/>
                </div>
                <div class="form-group">
                    <label id="labelNome" for="duracao">Duração</label>
                    <aux:duracao classe="form-control" id="duracao" nome="duracao" valor="${musica.duracao}" />
                </div>
                <div class="form-group">
                    <label id="labelNome" for="genero">Gênero</label>
                    <input id="genero" class="form-control" type="text" name="genero" required value="${musica.genero}"/>
                </div>
                <button type="submit" class="btn btn-primary" style="margin-bottom: 16px">Salvar</button>
            </form>
        </div>
        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">Duração</th>
                        <th scope="col">Gênero</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="c" items="${lista}"> 
                        <tr>
                            <td>${c.nome}</td>
                            <td>${c.duracao}</td>
                            <td>${c.genero}</td>
                            <td>
                                <a href="musicacdi?editar=${c.id}">
                                    <button class="btn btn-primary">Editar</button>
                                </a>
                                <a href="musicacdi?excluir=${c.id}">
                                    <button class="btn btn-danger">Excluir</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
