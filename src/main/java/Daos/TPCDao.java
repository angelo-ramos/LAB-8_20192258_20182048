package Daos;

import Beans.TPC;
import Beans.Tour;

import java.sql.*;
import java.util.ArrayList;

public class TPCDao {

    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

    public ArrayList<TPC> obtenerListaTpc(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<TPC> listaTpc = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select nombre_tour, ciudad, fecha from tours_por_ciudad tpc, tour t where t.idtour = tpc.tour")) {

            while (rs.next()) {
                String nombre_tour = rs.getString(1);
                String ciudad = rs.getString(2);
                String fecha = rs.getString(3);

                listaTpc.add(new TPC(fecha,nombre_tour,ciudad));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaTpc;
    }
}
