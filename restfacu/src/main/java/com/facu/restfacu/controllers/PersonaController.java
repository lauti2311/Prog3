package com.facu.restfacu.controllers;

import com.facu.restfacu.entities.Persona;
import com.facu.restfacu.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController {
    private PersonaService personaService;
    public PersonaController(PersonaService personaService){
        this.personaService = personaService;

    }
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\" Error, por favor intente mas tarde. \"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\" Error, por favor intente mas tarde. \"}");
        }
    }
    @PostMapping("") //Es post ya que se guarda la persona entidad
    public ResponseEntity<?> save(@RequestBody Persona entity){ //Se declara dentro del body con Request body,para recibir una entidad, se debe declarar en el body del post request
        try {                                               //Se envia la entidad
            return ResponseEntity.status(HttpStatus.OK).body(personaService.save(entity));
        }catch (Exception e){                          //Se envia un error bad requiest
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\" Error, por favor intente mas tarde. \"}");
        }
    }
    //Recordar que el <?> es una especie de comodin, indica que el tipo de dato que se contiene es generico, no se especifica en la declaracion
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@PathVariable Long id,@RequestBody Persona entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.update(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\" Error, por favor intente mas tarde. \"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {                                       //Esto indica que la respuesta no tiene contenido
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personaService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\" Error, por favor intente mas tarde. \"}");
        }
    }
}
