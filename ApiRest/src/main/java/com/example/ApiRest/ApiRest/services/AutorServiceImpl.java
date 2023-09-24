package com.example.ApiRest.ApiRest.services;

import com.example.ApiRest.ApiRest.entities.Autor;
import com.example.ApiRest.ApiRest.repositories.AutorRepository;
import com.example.ApiRest.ApiRest.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService {
    @Autowired
    AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository, AutorRepository autorRepository) {
        super(baseRepository);
    }
}
