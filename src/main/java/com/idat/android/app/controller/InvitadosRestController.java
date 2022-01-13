package com.idat.android.app.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.idat.android.app.model.Invitados;
import com.idat.android.app.service.InvitadosService;

@RestController
@RequestMapping("/api")
public class InvitadosRestController {
	
	@Autowired
	private InvitadosService service;
	
	@GetMapping("/listarInvitados")
	public List<Invitados> listar() {
		return (List<Invitados>) service.findAll();
	}
	
	@GetMapping("/listarFiltroInvitados/{num_depa}/{num_edi}")
    public ResponseEntity<List<Invitados>> buscarSomeProductos(@PathVariable("num_depa") Integer num_depa,@PathVariable("num_edi") String num_edi) {
        
		List<Invitados> listaInvitados =  service.findFiltrar(num_depa,num_edi);
		
		if (listaInvitados.isEmpty()) {
			
			return new ResponseEntity("Invitados no encontrados", HttpStatus.OK);
		}

        return new ResponseEntity<List<Invitados>>(listaInvitados, HttpStatus.OK);
    }
	
	@GetMapping("/listarInvitados/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") Integer id) {
		Optional<Invitados> invitados=service.findById(id);

		if (!invitados.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(invitados);
	}
	
	@PostMapping("/insertarInvitado")
	public ResponseEntity<Object> create(@RequestBody Invitados invitados) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(invitados));
	}
	
	@PutMapping("/modificarInvitado/{id_invitados}")
	public ResponseEntity<Object> actualizar(@RequestBody Invitados invitadosActualizar, @PathVariable(value= "id_invitados") Integer id_invitados) 
	{
	       Optional<Invitados> invitado=service.findById(id_invitados);
	       
	       if(!invitado.isPresent()) {
	    	   return ResponseEntity.notFound().build();
	       }

	    return ResponseEntity.status(HttpStatus.CREATED).body(service.update(invitadosActualizar));
	}
	
	@PostMapping("/eliminarInvitado/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}
	
	

}
