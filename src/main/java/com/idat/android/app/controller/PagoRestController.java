package com.idat.android.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.android.app.model.Pago;
import com.idat.android.app.service.PagoService;

@RestController
@RequestMapping("/api")
public class PagoRestController {

	private final PagoService service;

	public PagoRestController(PagoService service) {
		this.service = service;
	}

	@GetMapping("/listarPagos")
	public List<Pago> listarTodo() {
		return service.listar();
	}

	@PostMapping("/insertarPago")
	public Pago save(@Valid @RequestBody Pago p) {
		return this.service.save(p);
	}
	
	@GetMapping("/listarFiltroPago/{num_depa}/{num_edi}")
    public ResponseEntity<List<Pago>> buscarSomeProductos(@PathVariable("num_depa") Integer num_depa,@PathVariable("num_edi") String num_edi) {
        
		List<Pago> listarPagos =  service.findFiltrar(num_depa,num_edi);
		
		if (listarPagos.isEmpty()) {
			
			return new ResponseEntity("Pago no encontrados", HttpStatus.OK);
		}

        return new ResponseEntity<List<Pago>>(listarPagos, HttpStatus.OK);
    }
	

}
