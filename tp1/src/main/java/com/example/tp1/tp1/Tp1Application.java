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
	@Bean
	public CommandLineRunner init(ClienteRepository clienteRepository, DetallePedidoRepository detallePedidoRepository, DomicilioRepository domicilioRepository, FacturaRepository facturaRepository, PedidoRepository pedidoRepository, ProductoRepository productoRepository, RubroRepository rubroRepository, UsuarioRepository usuarioRepository) {
		return args -> {
			// Crear rubros
			Rubro rubro1 = Rubro.builder().denominacion("Electrónica").build();
			Rubro rubro2 = Rubro.builder().denominacion("Alimentos").build();

			// Crear productos asociados a rubros
			Producto producto1 = Producto.builder()
					.tipo("Manufacturado")
					.tiempoEstimadoCocina(0)
					.denominacion("Televisor")
					.precioVenta(599.99)
					.precioCompra(400.0)
					.stockActual(50)
					.stockMinimo(10)
					.unidadMedida("Unidades")
					.foto("tv.jpg")
					.receta("N/A")
					.build();
			producto1.setRubro(rubro1);

			Producto producto2 = Producto.builder()
					.tipo("Insumo")
					.tiempoEstimadoCocina(0)
					.denominacion("Arroz")
					.precioVenta(2.99)
					.precioCompra(1.0)
					.stockActual(200)
					.stockMinimo(20)
					.unidadMedida("Kilogramos")
					.foto("arroz.jpg")
					.receta("N/A")
					.build();
			producto2.setRubro(rubro2);

			// Crear usuarios que son clientes
			Usuario cliente1 = Usuario.builder()
					.nombre("Cliente1")
					.password("123456")
					.rol("Cliente")
					.build();



			Cliente cliente = Cliente.builder()
					.nombre("Jorge")
					.apellido("Rodriguez") // Asegúrate de incluir el apellido si es necesario
					.telefono("2616478933")
					.email("jorge@gmail.com")
					.build();
			clienteRepository.save(cliente);
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Calle 123")
					.numero("456")
					.localidad("Mendoza")
					.cliente(cliente)
					.build();
			// Crear pedidos para los clientes

			Pedido pedido1 = Pedido.builder()
					.fecha("2023-09-05")
					.estado("En progreso")
					.horaEstimadaEntrega("14:00")
					.tipoEnvio("Delivery")
					.total(0)
					.cliente(cliente) // Asignar el cliente al pedido
					.domicilio(domicilio1)
					.build();
			pedido1.setDomicilio(domicilio1);
			domicilio1.setPedidos(Collections.singletonList(pedido1));
			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(0)
					.producto(producto2)
					.build();
			detallePedido1.setPedido(pedido1);

			pedido1.setDetallesPedido(List.of(detallePedido1));
			pedido1.setUsuario(cliente1);

			// Crear una factura para el pedido
			Factura factura1 = Factura.builder()
					.fecha("2023-09-05")
					.numero(1)
					.descuento(0)
					.formaPago("Tarjeta")
					.total(0)
					.build();

			pedido1.setFactura(factura1);

			// Persistir los datos en la base de datos utilizando los repositorios
			rubroRepository.save(rubro1);
			rubroRepository.save(rubro2);
			productoRepository.save(producto1);
			productoRepository.save(producto2);
			usuarioRepository.save(cliente1);
			pedidoRepository.save(pedido1);
			detallePedidoRepository.save(detallePedido1);
			facturaRepository.save(factura1);
			pedidoRepository.save(pedido1);

			// Agregar un domicilio y asignarlo al pedido

		};
	}

}
