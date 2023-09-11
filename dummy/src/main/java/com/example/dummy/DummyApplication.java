package com.example.dummy;

import com.example.dummy.entidades.Persona;
import com.example.dummy.repositorios.PersonaRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DummyApplication {

	public static void main(String[] args) {

		SpringApplication.run(DummyApplication.class, args);


	}

	@Bean
	CommandLineRunner init(PersonaRepositorio personaRepositorio) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");

/*El método builder() se genera automáticamente por Lombok
y te permite crear una instancia de Persona.Builder.
Luego, puedes encadenar llamadas a los métodos
setters generados automáticamente para establecer los
valores de los atributos de la clase.
Finalmente, build() crea la instancia
 de la clase Persona con los valores proporcionados.

 */
			Persona persona = Persona.builder()
					.nombre("Juan")
					.apellido("Pérez")
					.edad(30)
					.build();


			personaRepositorio.save(persona);


			// Recuperar el objeto Persona desde la base de datos

			Persona personaRecuperada = personaRepositorio.findById(persona.getId()).orElse(null);
			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("Edad: " + personaRecuperada.getEdad());

			}
		};
	}
}