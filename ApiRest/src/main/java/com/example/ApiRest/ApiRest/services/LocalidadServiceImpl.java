package com.example.ApiRest.ApiRest.services;

import com.example.ApiRest.ApiRest.entities.Localidad;
import com.example.ApiRest.ApiRest.repositories.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {
    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }
}
