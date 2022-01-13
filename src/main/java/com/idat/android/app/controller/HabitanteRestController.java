package com.idat.android.app.controller;


import java.util.List;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.idat.android.app.model.Habitante;
import com.idat.android.app.service.HabitanteService;
import com.idat.android.app.service.utils.GenericResponse;

@RestController
@RequestMapping("api/habitante")
public class HabitanteRestController {
	
    private final HabitanteService service;

    public HabitanteRestController(HabitanteService service) {
        this.service = service;
    }
    
    @GetMapping("/listar")
    public List<Habitante> listarTodo(){
    	return service.listar();
    }

    @PostMapping
    public GenericResponse save(@Valid @RequestBody Habitante h){
        return this.service.save(h);
    }

    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @Valid @RequestBody Habitante h){
        h.setId(id);
        return this.service.save(h);
    }
}
