package com.qbo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qbo.model.sp.CursoNota;

@Repository
public interface CursoNotaRepository extends JpaRepository<CursoNota, String> {

	   @Query(value = "{call sp_ListarCursoxAlumno(:idalumno)}", 
	    		nativeQuery = true)
	   List<CursoNota> listarCursoNotaxAlumno(
	    		@Param("idalumno")String idAlumno);
}
