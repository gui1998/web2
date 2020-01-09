package servlet;

import cdi.DAOQualifier;
import dao.MusicaDAO;
import dao.MusicaDAOImpl;
import entidades.Musica;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MusicaCDIServlet", urlPatterns = {"/musicacdi"})
public class MusicaCDIServlet extends HttpServlet {
    
    @Inject @DAOQualifier
    private MusicaDAO dao;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Musica c = new Musica();

        if (request.getParameter("nome") != null) {
            if(!request.getParameter("id").equals("")){
                int id = Integer.parseInt(request.getParameter("id"));
                c.setId(id);
            }
            c.setNome(request.getParameter("nome"));
            c.setDuracao(request.getParameter("duracao"));
            c.setGenero(request.getParameter("genero"));
            dao.save(c);
        } else if (request.getParameter("excluir") != null) {
            int id = Integer.parseInt(request.getParameter("excluir"));
            dao.delete(dao.find(id));
        } else if (request.getParameter("editar") != null) {
            int id = Integer.parseInt(request.getParameter("editar"));

            request.setAttribute("musica", dao.find(id));
        }

        request.setAttribute("lista", dao.list());

        RequestDispatcher view = request.getRequestDispatcher("musicacdi.jsp");
        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
