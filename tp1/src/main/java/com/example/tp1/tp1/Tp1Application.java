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

			Usuario usuario1 = Usuario.builder().nombre("Jor").password("12345").rol("rol1").build();
			usuarioRepository.save(usuario1);

			Usuario usuario2 = Usuario.builder().nombre("Luc").password("65dscx").rol("rol2").build();
			usuarioRepository.save(usuario2);

			Rubro rubro1 = Rubro.builder().denominacion("Electrónica").build();
			rubroRepository.save(rubro1);

			Rubro rubro2 = Rubro.builder().denominacion("Ropa").build();
			rubroRepository.save(rubro2);

			Cliente cliente1 = Cliente.builder()
					.nombre("Jorge")
					.apellido("Perez")
					.telefono("1626865321")
					.email("jorge@gmail.com")
					.build();
			clienteRepository.save(cliente1);
			Producto producto1 = Producto.builder()
					.tipo("manufacturado")
					.tiempoEstimadoCocina(10)
					.denominacion("Televisor")
					.precioVenta(500.0)
					.precioCompra(400.0)
					.stockActual(5)
					.stockMinimo(2)
					.unidadMedida("unidad")
					.foto("foto")
					.receta("receta")
					.build();
			Producto producto2 = Producto.builder()
					.tipo("manufacturado")
					.tiempoEstimadoCocina(15)
					.denominacion("Laptop")
					.precioVenta(800.0)
					.precioCompra(700.0)
					.stockActual(10)
					.stockMinimo(5)
					.unidadMedida("unidad")
					.foto("foto")
					.receta("receta")
					.build();

			productoRepository.saveAll(Arrays.asList(producto1, producto2));
			rubro1.agregarProducto(producto1);
			rubroRepository.save(rubro1);
			rubro2.agregarProducto(producto2);
			rubroRepository.save(rubro2);

			Domicilio domicilioCliente1 = Domicilio.builder()
					.calle("Estrecho de San Carlos")
					.numero("5")
					.localidad("Las Heras")
					.build();

			domicilioRepository.save(domicilioCliente1);

// Crear un pedido para cliente1
			Pedido pedido1 = Pedido.builder()
					.fecha("2023-09-05")
					.horaEstimadaEntrega("15:25")
					.estado("EN CURSO")
					.tipoEnvio("DELIVERY")
					.total(200.0)
					.build();
// Asociar el domicilio al pedido1
			domicilioCliente1.setCliente(cliente1);
			domicilioCliente1.getPedidos().add(pedido1);
			pedidoRepository.save(pedido1);
			domicilioRepository.save(domicilioCliente1);
			usuario1.getPedidos().add(pedido1);
			usuarioRepository.save(usuario1);
// Agregar detalles al pedido1
			DetallePedido detalle1 = DetallePedido.builder().cantidad(2).subtotal(40.0).producto(producto1).build();
			DetallePedido detalle2 = DetallePedido.builder().cantidad(3).subtotal(90.0).producto(producto2).build();
			pedido1.setDetallesPedido(Arrays.asList(detalle1, detalle2));
// Asociar pedido1 a cliente1
			cliente1.setPedidos(Collections.singletonList(pedido1));
			clienteRepository.save(cliente1);
// Crear una factura para pedido1
			Factura factura1 = Factura.builder().fecha("2023-09-05").numero(1).descuento(0.0).formaPago("TARJETA").total(200.0).build();
			pedido1.setFactura(factura1); // Establecer la relación con la factura en Pedido
			facturaRepository.save(factura1); // Guardar la factura después de guardar el pedido
			pedidoRepository.save(pedido1);
// Crear un cliente2
			Cliente cliente2 = Cliente.builder()
					.nombre("Lucas")
					.apellido("Rodriguez")
					.telefono("2617587322")
					.email("LRodriguez@gmail.com")
					.build();
			clienteRepository.save(cliente2);
			Domicilio domicilioCliente2 = Domicilio.builder()
					.calle("Av. Gral San Martin")
					.numero("233")
					.localidad("Mendoza")
					.build();
			domicilioRepository.save(domicilioCliente2);
// Crear un pedido para cliente2
			Pedido pedido2 = Pedido.builder()
					.fecha("2023-09-06")
					.horaEstimadaEntrega("21:00")
					.estado("EN CURSO").tipoEnvio("DELIVERY")
					.total(300.0)
					.build();
// Asociar el domicilio al pedido2
			domicilioCliente2.setCliente(cliente2);
			domicilioCliente2.getPedidos().add(pedido2);
			pedidoRepository.save(pedido2);
			domicilioRepository.save(domicilioCliente2);
			usuario2.getPedidos().add(pedido2);
			usuarioRepository.save(usuario2);
// Agregar detalles al pedido2
			DetallePedido detalle3 = DetallePedido.builder().cantidad(1).subtotal(30.0).producto(producto1).build();
			DetallePedido detalle4 = DetallePedido.builder().cantidad(4).subtotal(120.0).producto(producto2).build();
			pedido2.setDetallesPedido(Arrays.asList(detalle3, detalle4));
			pedidoRepository.save(pedido2);
// Asociar pedido2 a cliente2
			cliente2.setPedidos(Collections.singletonList(pedido2));
			clienteRepository.save(cliente2);
			Factura factura2 = Factura.builder().fecha("2023-09-07").numero(1).descuento(0.0).formaPago("TARJETA").total(200.0).build();
			pedido2.setFactura(factura2); // Establecer la relación con la factura en Pedido
			facturaRepository.save(factura2); // Guardar la factura después de guardar el pedido
			pedidoRepository.save(pedido2);
		};

	}
}