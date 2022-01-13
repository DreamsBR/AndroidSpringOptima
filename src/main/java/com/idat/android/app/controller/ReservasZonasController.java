package com.idat.android.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.idat.android.app.model.ReservasZonas;
import com.idat.android.app.service.ReservasZonasService;

@RestController
@RequestMapping("/api")
public class ReservasZonasController {
	
	@Autowired
	private ReservasZonasService service;
	
	public ReservasZonasController(ReservasZonasService service) {
		this.service = service;
	}
	
	
	@GetMapping("/listarReservas")
    public List<ReservasZonas> listarTodo(){
    	return service.listar();
    }

	@PostMapping("/insertarReserva")
    public ReservasZonas save(@RequestBody ReservasZonas rz){
        return this.service.save(rz);
    }
}
