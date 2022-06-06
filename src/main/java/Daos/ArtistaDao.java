package Daos;

import Beans.Artista;

import java.sql.*;
import java.util.ArrayList;

public class ArtistaDao {

    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

    public ArrayList<Artista> obtenerListaArtista(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Artista> listaArtista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from artista;")) {

            while (rs.next()) {

                int idArtista = rs.getInt(1);
                String nombreArtista = rs.getString(2);
                String idInstrumento = rs.getString(3);
                String idBanda = rs.getString(4);

                listaArtista.add(new Artista(idArtista,nombreArtista,idInstrumento,idBanda));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaArtista;
    }
}
