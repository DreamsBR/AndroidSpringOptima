package com.idat.android.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.idat.android.app.model.Usuario;

public interface UsuariosDao extends CrudRepository<Usuario, Integer> {
    @Query("SELECT U FROM Usuario U WHERE U.email=:correo AND U.password=:password")
    Optional<Usuario> login(String correo, String password);
}
