package Servlets;

import Beans.Artista;
import Beans.TPC;
import Daos.ArtistaDao;
import Daos.TPCDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ArtistaServlet", value = "/listaArtistas")
public class ArtistaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArtistaDao artista = new ArtistaDao();
        ArrayList<Artista> listaArtista = artista.obtenerListaArtista();

        request.setAttribute("listaArtista",listaArtista);

        RequestDispatcher view =request.getRequestDispatcher("listaArtista.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
