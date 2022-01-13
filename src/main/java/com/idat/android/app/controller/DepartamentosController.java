package com.idat.android.app.controller;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.idat.android.app.model.Departamentos;
import com.idat.android.app.service.DepartamentosService;

@RestController
@RequestMapping("/api")
public class DepartamentosController {
	
	@Autowired
	private DepartamentosService service;
	
	String[] listarDepartamentos = null;

	@GetMapping("/listarDepartamentos")
	public List<Departamentos> listar() {
		return (List<Departamentos>) service.findAll();
	}

	@GetMapping("/listarDepartamentos/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") Integer id) {
		Optional<Departamentos> departamentos=service.findById(id);

		if (!departamentos.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(departamentos);
	}
	
	@GetMapping("/disponible")
    public ResponseEntity<Object> buscarDisponibles() {
        
        List<Departamentos> listaDisponibleActivos =service.findSomeDepartamentos();

        return new ResponseEntity<Object>(listaDisponibleActivos, HttpStatus.OK);
    }
	
	@PostMapping("/insertar")
	public ResponseEntity<Object> create(@RequestBody Departamentos departamentos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(departamentos));
	}
       
	@PutMapping("/modificar/{id}")
	public ResponseEntity<Object> actualizar(@RequestBody Departamentos departamentoActualizar, @PathVariable(value= "id")
	Integer id_departamento) 
	    {
	       Optional<Departamentos> departamento=service.findById(id_departamento);
	       
	       if(!departamento.isPresent()) {
	    	   return ResponseEntity.notFound().build();
	       }
	    departamento.get().setDescripcion(departamentoActualizar.getDescripcion());
	    departamento.get().setPrecio(departamentoActualizar.getPrecio());
	    departamento.get().setEstado(departamentoActualizar.getEstado());
	    departamento.get().setFoto(departamentoActualizar.getFoto());
	    departamento.get().setEdificio(departamentoActualizar.getEdificio());
	    
	    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(departamento.get()));
	    
	  }
	@DeleteMapping("/listarDepartamentos/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}	
	
	@GetMapping("/departamentos/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
	
		Path rutaArchivo = Paths.get("departamentos").resolve(nombreFoto).toAbsolutePath();
		Resource recurso = null;
		
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if (!recurso.exists() && !recurso.isReadable()) {
			rutaArchivo = Paths.get("src/main/resources/static/imageness").resolve("not-found.png").toAbsolutePath();
			
			try {
				recurso = new UrlResource(rutaArchivo.toUri());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		
		return new ResponseEntity<Resource> (recurso, cabecera,HttpStatus.OK);
	}
}