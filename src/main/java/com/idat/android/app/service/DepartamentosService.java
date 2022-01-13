package com.idat.android.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.android.app.dao.DepartamentosDao;
import com.idat.android.app.model.Departamentos;


@Service
@Transactional
public class DepartamentosService {

	@Autowired
	private DepartamentosDao dao;
	
	public List<Departamentos> findAll(){
		return (List<Departamentos>) dao.findAll();
	}
	
	public Departamentos save(Departamentos departamentos) {
		return dao.save(departamentos);
	}
	
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
	
	public List<Departamentos> findSomeDepartamentos() {
        return (List<Departamentos>) dao.findSomeDepartamentos();
	}

	public String[] obtenerDepartamentos() {
		return dao.obtenerDepartamentos();
	}

	public Optional<Departamentos> findById(Integer id){
		return dao.findById(id);
	}
	
	 public Departamentos update(Departamentos departamentos){
		 Departamentos depa = dao.save(departamentos);
			return depa;
		}

}
                 