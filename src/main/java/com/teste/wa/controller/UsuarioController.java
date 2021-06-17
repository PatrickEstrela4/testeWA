package com.teste.wa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.teste.wa.dto.UsuarioDTO;
import com.teste.wa.dto.UsuarioRespostaDTO;
import com.teste.wa.model.Usuario;
import com.teste.wa.service.SequenceGeneratorService;
import com.teste.wa.service.UsuarioService;

/**
 * @author Patrick E. Estrela
 * @Data 21/09/20
 */
@Controller
public class UsuarioController {

	public static final String DATE_FORMAT = "dd/MM/yyyy";
	@Autowired
	private final UsuarioService usuarioservice;
	@Autowired
	private final SequenceGeneratorService sequenceGeneratorService;
	
	public UsuarioController(UsuarioService usuarioservice,SequenceGeneratorService sequenceGeneratorService) {
		this.usuarioservice = usuarioservice;
		this.sequenceGeneratorService = sequenceGeneratorService;
	}
	
	
	public List<UsuarioRespostaDTO> listarContatos() {
		return listObjectToListDTO(usuarioservice.ListarTodos()); 
	}
	
	public UsuarioRespostaDTO salvar(UsuarioDTO usuarioNovo) {
		return new UsuarioRespostaDTO(usuarioservice.salvar(usuarioNovo.DTOtoObject(sequenceGeneratorService.generateSequence(Usuario.SEQUENCE_NAME))));
		
	}
	
	public List<UsuarioRespostaDTO> salvarLista(List<UsuarioDTO> usuarioNovo) {
		return listObjectToListDTO(usuarioservice.salvarLista(listDTOTolistObject(usuarioNovo)));
		
	}
	
	
	public List<UsuarioRespostaDTO> listObjectToListDTO(List<Usuario> usuarios){
		List<UsuarioRespostaDTO> retorno = new ArrayList<UsuarioRespostaDTO>();
		for (Usuario usuario : usuarios) {
			if(usuario != null)
				retorno.add(new UsuarioRespostaDTO(usuario));
		}
		return retorno;
		
	}
	
	public List<Usuario> listDTOTolistObject(List<UsuarioDTO> usuarios){
		List<Usuario> retorno = new ArrayList<Usuario>();
		for (UsuarioDTO usuario : usuarios) {
			if(usuario != null)
			retorno.add(usuario.DTOtoObject(sequenceGeneratorService.generateSequence(Usuario.SEQUENCE_NAME)));
		}
		return retorno;
		
	}

	public List<UsuarioRespostaDTO> gerUsuario(String id) {
		return listObjectToListDTO(usuarioservice.getUsuario(id));
	}


	public UsuarioRespostaDTO gerUsuarioId(long id) {
		return new UsuarioRespostaDTO(usuarioservice.getUsuarioID(id));
	}
}
