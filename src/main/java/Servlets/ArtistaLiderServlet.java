package Servlets;

import Beans.Artista;
import Daos.ArtistaDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ArtistaLiderServlet", value = "/listaLideres")
public class ArtistaLiderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArtistaDao artista = new ArtistaDao();
        ArrayList<Artista> listaLideres = artista.obtenerLideres();

        request.setAttribute("listaLideres",listaLideres);

        RequestDispatcher view =request.getRequestDispatcher("listaLideres.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
