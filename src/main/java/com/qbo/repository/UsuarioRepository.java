package com.qbo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qbo.model.bd.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	   @Query(value = "SELECT * FROM Usuario WHERE NomUsuario=:NomUsuario AND PassUsuario=:PassUsuario", 
	    		nativeQuery = true)
	    Usuario autenticarUsuario(
	    		@Param("NomUsuario")String NomUsuario,
	    		@Param("PassUsuario")String PassUsuario);

}
