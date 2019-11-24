<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="entidades.Reserva" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" />
        <link rel="stylesheet" href="resources/css/bootstrap-reboot.min.css" type="text/css">

    </head>
    <body>
        <h1>Reserva</h1>
        <%
          int id = 0;
          String nomecompleto = "";
          String telefone = "";
          String nomepet = "";
          String datareserva = "";
          if(request.getAttribute("reserva")!=null){
            Reserva ed = (Reserva) request.getAttribute("reserva");
            
            id = ed.getId();
            nomecompleto=ed.getNomecompleto();
            nomepet=ed.getNomepet();
            telefone=ed.getTelefone();
            //datareserva = ed.getDatareserva();
        }
         
        %>
        <div class="container">
            <form  method="POST" action="reserva">
                
                <div class="form-group">
                    <input class="form-control" type="hidden" id="id" name="id" required value="<%= id %>"/>
                </div>
                
                <div class="form-group">
                    <label id="labelNome" for="nome">Nome:</label>
                    <input class="form-control" type="text" id="nomecompleto" name="nomecompleto" required value="<%= nomecompleto %>"/>
                </div>

                <div class="form-group">
                    <label id="labelNome" for="cpf">Nome Pet:</label>
                    <input class="form-control" type="text" id="nomepet" name="nomepet" required value="<%= nomepet %>" />
                </div>

                <div class="form-group">
                    <label id="labelNome" for="telefone">Telefone:</label>
                    <input class="form-control" type="text" id="telefone" name="telefone" required value="<%= telefone %>" />
                </div>
                
                <div class="form-group">
                    <label id="labelNome" for="telefone">Data Reserva:</label>
                    <input class="form-control" type="text" id="datareserva" name="datareserva" required value="<%= datareserva %>" />
                </div>
                
                <button id="salvar" class="btn btn-primary" type="submit">Salvar</button>
            </form>
        </div>
        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                <th scope='col'>Nome:</th>
                <th scope='col'>Nome Pet:</th>
                <th scope='col'>Ações</th>
                </thead>

                <tbody>
                    <%
                        List<Reserva> lista;
                            lista = (List<Reserva>) request.getAttribute("lista");
                    %>
                    <%
                     for(Reserva c : lista){            
                    %>
                    <tr>
                        <td><%= c.getNomecompleto() %></td>
                        <td><%= c.getNomepet() %></td>
                        <td>
                            <a href="reserva?editar=<%= c.getId()%>">
                                <button class="btn btn-primary">Editar</button>
                            </a>
                                <a href="reserva?excluir=<%= c.getId()%>">
                                <button class="btn btn-danger">Ecluir</button>
                            </a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
