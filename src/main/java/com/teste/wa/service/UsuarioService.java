package com.teste.wa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.teste.wa.model.Usuario;
import com.teste.wa.repository.UsuarioRepository;

/**
 * @author Patrick E. Estrela
 * @Data 21/09/20
 */
@Service
public class UsuarioService {

	@Autowired
	private final UsuarioRepository usuarioRepository;
	
	
	public UsuarioService(UsuarioRepository repository) {
		this.usuarioRepository = repository;
	}
	
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
		
	}
	
	
	public List<Usuario> salvarLista(List<Usuario> usuario) {
		List<Usuario> retorno = new ArrayList<Usuario>();
		
		for (Usuario usuario2 : usuario) {
			retorno.add(salvarAssync(usuario2));
		}
		
		return retorno;
		
	}
	
	@Async("threadPoolTaskExecutor")
	public Usuario salvarAssync(Usuario usuario) {
		return usuarioRepository.save(usuario);
		
	}
	
	public List<Usuario> ListarTodos() {
		return usuarioRepository.findAll();
		
	}
	
	public List<Usuario> getUsuario(String id) {
		return usuarioRepository.findByNome(id);
		
	}

	public Usuario getUsuarioID(long id) {
		return usuarioRepository.findById(id);
	}
	
}
