/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ReservaDAO;
import dao.ReservaDAOImpl;
import entidades.Reserva;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ReservaServlet", urlPatterns = {"/reserva"})
public class ReservaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        Reserva c = new Reserva();
        ReservaDAOImpl dao = new ReservaDAOImpl();

        if (request.getParameter("nomecompleto") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            c.setId(id);
            c.setNomecompleto(request.getParameter("nomecompleto"));
            c.setNomepet(request.getParameter("nomepet"));
            c.setTelefone(request.getParameter("telefone"));
             String dataStr = request.getParameter("datareserva");

            try{
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                c.setDatareserva(sdf.parse(dataStr));
            }catch(ParseException erro){

            }
            dao.save(c);
        } else if (request.getParameter("excluir") != null) {
            int id = Integer.parseInt(request.getParameter("excluir"));
            dao.delete(dao.find(id));
        } else if (request.getParameter("editar") != null) {
            int id = Integer.parseInt(request.getParameter("editar"));
            c = dao.find(id);
            request.setAttribute("reserva", c);
        }

       

        request.setAttribute("lista", dao.list());

        RequestDispatcher view = request.getRequestDispatcher("reserva.jsp");
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
