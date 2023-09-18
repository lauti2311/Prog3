package com.facu.restfacu.services;

import java.util.List;

public interface BaseService<E> {
    public List<E> findAll() throws Exception; //Trae una lista de las personas que se encuentran en la BD
    public E findById(Long id) throws Exception; //Trae el id buscado especificamente
    public E save(E entity) throws Exception; //Crea una nueva entidad

    public E update(Long id, E entity) throws Exception; //Actualiza la entidad que se quiere

    public boolean delete (Long id) throws Exception; //Borra la entidad
}
