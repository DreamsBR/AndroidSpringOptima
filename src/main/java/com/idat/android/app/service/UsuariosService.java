package com.idat.android.app.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.idat.android.app.dao.UsuariosDao;
import com.idat.android.app.model.Usuario;
import com.idat.android.app.service.utils.GenericResponse;
import com.idat.android.app.service.utils.Globals;


@Service
@Transactional
public class UsuariosService {
    private final UsuariosDao dao;

    public UsuariosService(UsuariosDao dao) {
        this.dao = dao;
    }
    
    //Método para iniciar sesión
    public GenericResponse<Usuario> login(String email, String password){
        Optional<Usuario> optU = this.dao.login(email, password);
        if(optU.isPresent()){
            return new GenericResponse<Usuario>(Globals.TIPO_AUTH, Globals.RPTA_OK, "Haz iniciado sesión correctamente", optU.get());
        }else{
            return new GenericResponse<Usuario>(Globals.TIPO_AUTH, Globals.RPTA_WARNING, "Lo sentimos, ese usuario no existe", new Usuario());
        }
    }
    
    //Método para guardar credenciales del usuario
	public GenericResponse<Usuario> guardarUsuario(Usuario u){
        Optional<Usuario> optU = this.dao.findById(u.getId());
        int idf = optU.isPresent() ? optU.get().getId() : 0;
        if(idf == 0){
            return new GenericResponse<Usuario>(Globals.TIPO_DATA, Globals.RPTA_OK, "Usuario Registrado Correctamente", this.dao.save(u));
        }else{
            return new GenericResponse<Usuario>(Globals.TIPO_DATA, Globals.RPTA_OK, "Datos del usuario actualizados", this.dao.save(u));
        }
    }
}

