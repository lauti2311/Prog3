package com.example.ApiRest.ApiRest.controllers;

import com.example.ApiRest.ApiRest.entities.Base;
import com.example.ApiRest.ApiRest.entities.Persona;
import com.example.ApiRest.ApiRest.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> {
    @Autowired
    protected S servicio;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\" Error, por favor intente mas tarde. \"}");
        }
    }

    @GetMapping("/paged")
    public ResponseEntity<?> getAll(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\" Error, por favor intente mas tarde. \"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\" Error, por favor intente mas tarde. \"}");
        }
    }
    @PostMapping("") //Es post ya que se guarda la persona entidad
    public ResponseEntity<?> save(@RequestBody E entity){ //Se declara dentro del body con Request body,para recibir una entidad, se debe declarar en el body del post request
        try {                                               //Se envia la entidad
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        }catch (Exception e){                          //Se envia un error bad requiest
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\" Error, por favor intente mas tarde. \"}");
        }
    }
    //Recordar que el <?> es una especie de comodin, indica que el tipo de dato que se contiene es generico, no se especifica en la declaracion
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@PathVariable Long id,@RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\" Error, por favor intente mas tarde. \"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {                                       //Esto indica que la respuesta no tiene contenido
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\" Error, por favor intente mas tarde. \"}");
        }
    }
}
