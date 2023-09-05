package com.example.tp1.tp1;

import com.example.tp1.tp1.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tp1Application {
@Autowired
	UsuarioRepository usuarioRepository;
	public static void main(String[] args) {


		SpringApplication.run(Tp1Application.class, args);
		System.out.println("Estoy funcionando");
	}

}
