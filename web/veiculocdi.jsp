<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="aux" tagdir="/WEB-INF/tags/" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src='resources/js/jquery.min.js'></script>
        <script src='resources/js/bootstrap.min.js'></script>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Formulário de Veiculo:</h1>       

        <div class="container">
            <form method="POST" action="veiculocdi">
                <input name="id" type="hidden" value="${veiculo.id}"/>
                <div class="form-group">
                    <label id="labelNome" for="modelo">Modelo:</label>
                    <input id="modelo" class="form-control" name="modelo" type="text" required  value="${veiculo.modelo}"/>
                </div>
                <div class="form-group">
                    <label id="labelNome" for="placa">Placa:</label>
                    <aux:placa classe="form-control" id="placa" nome="placa" valor="${veiculo.placa}" />
                </div>
                <div class="form-group">
                    <label id="labelNome" for="telefone">Marca:</label>
                    <input id="marca" class="form-control" name="marca" type="text" required value="${veiculo.marca}"/>
                </div>
                <button type="submit" class="btn btn-primary" style="margin-bottom: 16px">Salvar</button>
            </form>
        </div>
        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Modelo</th>
                        <th scope="col">Placa</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="c" items="${lista}"> 
                        <tr>
                            <td>${c.modelo}</td>
                            <td>${c.placa}</td>
                            <td>
                                <a href="veiculocdi?editar=${c.id}">
                                    <button class="btn btn-primary">Editar</button>
                                </a>
                                <a href="veiculocdi?excluir=${c.id}">
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
