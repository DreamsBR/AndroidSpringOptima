package com.idat.android.app.controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.idat.android.app.model.Usuario;
import com.idat.android.app.service.UsuariosService;
import com.idat.android.app.service.utils.GenericResponse;


@RestController
@RequestMapping("api/usuario")
public class UsuarioRestController {
	
	
	private final UsuariosService service;

    public UsuarioRestController(UsuariosService service) {
        this.service = service;
    }
	

	
    @PostMapping("/login")
    public GenericResponse<Usuario> login(HttpServletRequest request){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        return this.service.login(email, password);
    }
    
    @PostMapping
    public GenericResponse save(@RequestBody Usuario u){
        return this.service.guardarUsuario(u);
    }
    
    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @RequestBody Usuario u){
        return this.service.guardarUsuario(u);
    }

}
