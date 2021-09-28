package com.qbo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbo.model.bd.Usuario;
import com.qbo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void registrarCurso(Usuario usuario) {
		//usuarioRepository.save(usuario);
	}
	
	public Usuario autenticarUsuario(Usuario usuario){
		return usuarioRepository.autenticarUsuario(
				usuario.getNomusuario(),
				usuario.getPassusuario());
	}
	

	

	
	
}
