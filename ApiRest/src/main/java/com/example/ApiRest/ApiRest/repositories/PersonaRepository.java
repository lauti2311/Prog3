package com.example.ApiRest.ApiRest.repositories;

import com.example.ApiRest.ApiRest.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long>{

    //Anotacion metodo de query
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    boolean existsByDni(int dni);

    //Anotaciones JPQL parametros indexados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?1%' OR p.apellido LIKE  '%?1%'")
    List<Persona> search(String filtro);

    @Query(value = "SELECT * FROM persona WHERE persona.nombre LIKE '%?1%' OR persona.apellido LIKE  '%?1%'",
            nativeQuery = true

    )
    List<Persona> search1(String filtro);
}
