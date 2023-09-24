package com.example.ApiRest.ApiRest.services;

import com.example.ApiRest.ApiRest.entities.Persona;
import com.example.ApiRest.ApiRest.repositories.BaseRepository;
import com.example.ApiRest.ApiRest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{
    //@Autowired Esto nos ahorra el constructor que cree mas abajo de public PersonaService
    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository) {
        super(baseRepository);
        this.personaRepository = personaRepository;
    }
}
