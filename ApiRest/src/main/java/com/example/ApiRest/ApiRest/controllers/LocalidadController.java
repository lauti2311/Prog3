package com.example.ApiRest.ApiRest.controllers;

import com.example.ApiRest.ApiRest.entities.Localidad;
import com.example.ApiRest.ApiRest.services.LocalidadServiceImpl;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl> {
}
