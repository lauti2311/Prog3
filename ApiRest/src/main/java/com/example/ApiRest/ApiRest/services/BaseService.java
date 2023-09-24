package com.example.ApiRest.ApiRest.services;

import com.example.ApiRest.ApiRest.entities.Base;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, ID extends Serializable>{

    public List<E> findAll() throws Exception; //Trae una lista de las personas que se encuentran en la BD
    public E findById(ID id) throws Exception; //Trae el id buscado especificamente
    public E save(E entity) throws Exception; //Crea una nueva entidad

    public E update(ID id, E entity) throws Exception; //Actualiza la entidad que se quiere

    public boolean delete (ID id) throws Exception; //Borra la entidad


}
