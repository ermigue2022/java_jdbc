package com.macuevas.java.jdbc;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_curso";
        String username = "root";
        String password = "root";


        /* Try con recurso, la finalización de las conexiones son automáticas*/
        try(Connection conn = DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM productos")) {

            while (resultado.next()){
                System.out.print(resultado.getInt("id"));
                System.out.print("  |  ");
                System.out.print(resultado.getString("nombre"));
                System.out.print("  |  ");
                System.out.print(resultado.getInt("precio"));
                System.out.print("  |  ");
                System.out.println(resultado.getDate("fecha_registro"));


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);


        }
    }
}
