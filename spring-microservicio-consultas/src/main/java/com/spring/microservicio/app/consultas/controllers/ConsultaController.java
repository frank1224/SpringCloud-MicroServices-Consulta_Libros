package com.spring.microservicio.app.consultas.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.microservicio.app.consultas.models.Consulta;
import com.spring.microservicio.app.consultas.models.Editorial;
import com.spring.microservicio.app.consultas.models.Libro;
import com.spring.microservicio.app.consultas.services.IConsultaService;

@RestController
public class ConsultaController {

	public ConsultaController() {}
	
	@Qualifier("ConsultaServiceFeign")
	@Autowired
	private IConsultaService consultaService;
	
	private Logger log = LoggerFactory.getLogger(ConsultaController.class);
	
	/**
	 * Referencia al archivo de config
	 */
	@Value("${configuracion.texto}")
	private String texto;
	
	/**
	 * Perfiles de config
	 */
	@Autowired
	private Environment env;
	
	@GetMapping("/listar")
	public List<Consulta> list (){
		return consultaService.findAll();
				
	}	
	
	@HystrixCommand(fallbackMethod = "rutaAlternativa")
	@GetMapping("/ver/{id}")
	public Consulta detail(@PathVariable (value = "id") Long id) {
		
		return consultaService.findById(id);
		
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Libro crear(@RequestBody Libro libro) {
		
		return consultaService.save(libro);
		
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Libro editar(@RequestBody Libro libro, @PathVariable (value = "id") Long id) {
		
		return consultaService.update(libro, id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable (value = "id") Long id) {
		
		consultaService.deleteById(id);
	}
	
	
	public Consulta rutaAlternativa (Long id) {
		
		Consulta consulta = new Consulta();
		Libro libro = new Libro();

		libro.setId(id);
		libro.setName("Ocurrio algo inesperado, intentelo de nuevo en unos minutos");
		libro.setPrice(0.0);
		libro.setEditoriales(null);
		
		consulta.setLibro(libro);
		
		return consulta;
		
	}

	@GetMapping("/obtenerConfig")
	public ResponseEntity<?> obtenerConfig(){
		
		log.info(texto);
		HashMap<String, String> json = new HashMap<>();
		json.put("texto", texto);
		
		if (env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("dev")) {
			json.put("autor.nombre", env.getProperty("configuracion.autor.nombre"));
			json.put("autor.email", env.getProperty("configuracion.autor.email"));
			
		}
		
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
		
		
	}
	

}
