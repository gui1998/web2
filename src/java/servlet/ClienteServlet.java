/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import entidades.Cliente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilh
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/cliente"})
public class ClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        Cliente c = new Cliente();
        ClienteDAOImpl dao = new ClienteDAOImpl();
    
        if(request.getParameter("nome") != null){
            int id = Integer.parseInt(request.getParameter("id"));
            c.setId(id);
            c.setNome(request.getParameter("nome"));
            c.setCpf(request.getParameter("cpf"));
            c.setTelefone(request.getParameter("telefone"));
            dao.save(c);
        } else if (request.getParameter("excluir") != null) {
            int id = Integer.parseInt(request.getParameter("excluir"));
            dao.delete(dao.find(id));
        }else if (request.getParameter("editar") != null) {
            int id = Integer.parseInt(request.getParameter("editar"));
            c = dao.find(id);
            request.setAttribute("cliente", c);
        }
        
        
        
        request.setAttribute("lista", dao.list());
        
        RequestDispatcher view = request.getRequestDispatcher("cliente.jsp");
        view.forward(request, response);
        
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
