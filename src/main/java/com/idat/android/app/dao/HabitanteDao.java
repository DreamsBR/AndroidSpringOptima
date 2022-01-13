package com.idat.android.app.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.idat.android.app.model.Departamentos;
import com.idat.android.app.model.Habitante;

public interface HabitanteDao extends CrudRepository<Habitante, Integer> {
    @Query(value = "(SELECT EXISTS(SELECT id FROM habitantes WHERE num_doc=:dni))", nativeQuery = true)
    int existByDoc(String dni);
    @Query(value = "(SELECT EXISTS(SELECT id FROM habitantes WHERE num_departamento=:num_depa))", nativeQuery = true)
    int existByDepa(String num_depa);
    @Query(value = "SELECT EXISTS(SELECT H.* FROM habitantes H WHERE H.num_doc=:dni AND NOT (H.id=:id))", nativeQuery = true)
    int existByDocForUpdate(String dni, int id);
}
