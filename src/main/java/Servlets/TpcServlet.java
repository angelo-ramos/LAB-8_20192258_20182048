package Servlets;

import Beans.TPC;
import Beans.Tour;
import Daos.TPCDao;
import Daos.TourDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TpcServlet", value = "/listaToursporCiudad")
public class TpcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TPCDao tpcDao = new TPCDao();
        ArrayList<TPC> listaTpc = tpcDao.obtenerListaTpc();

        request.setAttribute("listaTpc",listaTpc);

        RequestDispatcher view =request.getRequestDispatcher("listaTPC.jsp");
        view.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
