package com.idat.android.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.android.app.model.Departamentos;

@Repository
public interface DepartamentosDao extends CrudRepository<Departamentos, Integer> {
	
	@Query("from Departamentos")
	public String[] obtenerDepartamentos(); 
	
	@Query("from Departamentos p where p.estado='disponible'")
    public List<Departamentos> findSomeDepartamentos();


}
