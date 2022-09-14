package com.macuevas.java.jdbc;

import com.macuevas.java.jdbc.modelo.Producto;
import com.macuevas.java.jdbc.repositorio.ProductoRepositorioImpl;
import com.macuevas.java.jdbc.repositorio.Repositorio;
import com.macuevas.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {

        /* Try con recurso, la finalización de las conexiones son automáticas*/
        try (Connection conn = ConexionBaseDatos.getInstance()){

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(System.out::println); /*listado de todos los productos y todos sus campos*/
            System.out.println(repositorio.porId(2L)); /*lista solo el producto indicado en el id, en este caso el 2*/

        } catch (SQLException e) {
            throw new RuntimeException(e);


        }
    }
}
