package com.idat.android.app.service;

import org.springframework.stereotype.Service;

import com.idat.android.app.dao.HabitanteDao;
import com.idat.android.app.model.Habitante;
import com.idat.android.app.service.utils.GenericResponse;
import com.idat.android.app.service.utils.Globals;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class HabitanteService {
    private final HabitanteDao dao;

    public HabitanteService(HabitanteDao dao) {
        this.dao = dao;
    }
    
    public List<Habitante> listar(){
    	return (List<Habitante>) dao.findAll();
    }

    //Método para guardar y actualizar habitante
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericResponse save(Habitante h){
        Optional<Habitante> opt = this.dao.findById(h.getId());
        int idf = opt.isPresent() ? opt.get().getId() : 0;
        if(idf == 0){
            if(dao.existByDoc(h.getNumDoc().trim()) == 1){
                return new GenericResponse(Globals.TIPO_RESULT, Globals.RPTA_WARNING,"Lo sentimos, número de documento registrado", null);
            }
            if(dao.existByDepa(h.getNumDepartamento().trim()) == 1){
                    return new GenericResponse(Globals.TIPO_RESULT, Globals.RPTA_WARNING,"Lo sentimos, departamento ocupado", null);
            }else{
                //Guarda
                h.setId(idf);
                return new GenericResponse(Globals.TIPO_DATA, Globals.RPTA_OK, "Habitante registrado correctamente", this.dao.save(h));
            }
        }else{
            //Actualizar Registro
            if(dao.existByDocForUpdate(h.getNumDoc().trim(), h.getId()) == 1){
                return new GenericResponse(Globals.TIPO_RESULT, Globals.RPTA_WARNING, "Error: Ya existe un habitante con esos mismos datos", null);
            }else{
                //Actualiza
                h.setId(idf);
                return new GenericResponse(Globals.TIPO_DATA, Globals.RPTA_OK, "Datos del habitante actualizado", this.dao.save(h));
            }
        }
    }
}
