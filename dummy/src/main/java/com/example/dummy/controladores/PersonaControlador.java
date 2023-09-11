package com.example.dummy.controladores;

import com.example.dummy.repositorios.PersonaRepositorio;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")

@RequestMapping(path = "api/personas")
public class PersonaControlador {
    @Autowired
    private PersonaRepositorio personaRepositorio;

    @GetMapping("dummy")
    public ResponseEntity<String> getDummy(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Lo que me solicitaste soy dummy");
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }

    @GetMapping("subRuta")
    public ResponseEntity<String> chauDummy(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Lo que me solicitaste soy dummy del chau");
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(personaRepositorio.findById(1L));
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(personaRepositorio.findAll());
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody String persona) {
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Te devuelvo la persona creada " + persona);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> upddate(@PathVariable Long id, @RequestBody String persona){



        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(" Te devuelvo la presona actualizada : " + persona);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor intente luego\"}");
        }

    }




    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){



        try {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(" Eliminaste el registro : " + id );
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor intente luego\"}");
        }

    }
}
