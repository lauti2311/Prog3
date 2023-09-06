package com.example.tp1.tp1;

import com.example.tp1.tp1.entidades.*;
import com.example.tp1.tp1.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Tp1Application {
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DomicilioRepository domicilioRepository;

	public static void main(String[] args) {


		SpringApplication.run(Tp1Application.class, args);
		System.out.println("Estoy funcionando");
	}

	/*@Bean
	public CommandLineRunner init(ClienteRepository clienteRepository, DetallePedidoRepository detallePedidoRepository, DomicilioRepository domicilioRepository, FacturaRepository facturaRepository, PedidoRepository pedidoRepository, ProductoRepository productoRepository, RubroRepository rubroRepository, UsuarioRepository usuarioRepository) {
		return args -> {


		};*/
	}

