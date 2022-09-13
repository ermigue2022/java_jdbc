package com.macuevas.java.jdbc.repositorio;

import java.util.List;

public interface Repositorio<T>{

    List<T> listar();

    T porId(Long id);

    void guardar(T t); /* reutilizamos para insertar o modificar */

    void eliminar(Long id);

}
