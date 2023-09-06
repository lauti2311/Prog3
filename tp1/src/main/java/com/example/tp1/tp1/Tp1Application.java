package com.example.tp1.tp1;

import com.example.tp1.tp1.entidades.*;
import com.example.tp1.tp1.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
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

	@Bean
	public CommandLineRunner init(ClienteRepository clienteRepository, DetallePedidoRepository detallePedidoRepository, DomicilioRepository domicilioRepository, FacturaRepository facturaRepository, PedidoRepository pedidoRepository, ProductoRepository productoRepository, RubroRepository rubroRepository, UsuarioRepository usuarioRepository) {
		return args -> {

			Cliente cliente1 = Cliente.builder().nombre("Jorge").apellido("Perez").telefono("1626865321").email("jorge@gmail.com").build();
			clienteRepository.save(cliente1);

			// Crear productos
			Producto producto1 = Producto.builder().tipo("manufacturado").tiempoEstimadoCocina(10).denominacion("Televisor").precioVenta(500.0).precioCompra(400.0).stockActual(5).stockMinimo(2).unidadMedida("unidad").foto("foto").receta("receta").build();
			Producto producto2 = Producto.builder().tipo("manufacturado").tiempoEstimadoCocina(15).denominacion("Laptop").precioVenta(800.0).precioCompra(700.0).stockActual(10).stockMinimo(5).unidadMedida("unidad").foto("foto").receta("receta").build();
			productoRepository.saveAll(Arrays.asList(producto1, producto2));

			// Crear un pedido para cliente1
			Pedido pedido1 = Pedido.builder().fecha("2023-09-05").estado("EN CURSO").tipoEnvio("DELIVERY").total(200.0).build();
			pedidoRepository.save(pedido1);

			// Agregar detalles al pedido1
			DetallePedido detalle1 = DetallePedido.builder().cantidad(2).subtotal(40.0).producto(producto1).build();
			DetallePedido detalle2 = DetallePedido.builder().cantidad(3).subtotal(90.0).producto(producto2).build();
			pedido1.setDetallesPedido(Arrays.asList(detalle1, detalle2));
			pedidoRepository.save(pedido1);

			// Asociar pedido1 a cliente1
			cliente1.setPedidos(Collections.singletonList(pedido1));
			clienteRepository.save(cliente1);
			// Crear una factura para pedido1
			Factura factura1 = Factura.builder().fecha("2023-09-05").numero(1).descuento(0.0).formaPago("TARJETA").total(200.0).build();
			pedido1.setFactura(factura1); // Establecer la relación con la factura en Pedido
			facturaRepository.save(factura1); // Guardar la factura después de guardar el pedido


			// Crear un cliente2
			Cliente cliente2 = Cliente.builder().nombre("Lucas").apellido("Rodriguez").telefono("2617587322").email("LRodriguez@gmail.com").build();
			clienteRepository.save(cliente2);

			// Crear un pedido para cliente2
			Pedido pedido2 = Pedido.builder().fecha("2023-09-06").estado("EN CURSO").tipoEnvio("DELIVERY").total(300.0).build();
			pedidoRepository.save(pedido2);
			// Crear una factura para pedido2
			Factura factura2 = Factura.builder().fecha("2023-09-06").numero(2).descuento(0.0).formaPago("EFECTIVO").total(300.0).build();
			pedido2.setFactura(factura2); // Establecer la relación con la factura en Pedido
			facturaRepository.save(factura2);

			// Agregar detalles al pedido2
			DetallePedido detalle3 = DetallePedido.builder().cantidad(1).subtotal(30.0).producto(producto1).build();
			DetallePedido detalle4 = DetallePedido.builder().cantidad(4).subtotal(120.0).producto(producto2).build();
			pedido2.setDetallesPedido(Arrays.asList(detalle3, detalle4));
			pedidoRepository.save(pedido2);

			// Asociar pedido2 a cliente2
			cliente2.setPedidos(Collections.singletonList(pedido2));
			clienteRepository.save(cliente2);


		};

	}
}