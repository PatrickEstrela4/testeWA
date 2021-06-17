package com.teste.wa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teste.wa.controller.UsuarioController;
import com.teste.wa.dto.UsuarioDTO;
import com.teste.wa.dto.UsuarioRespostaDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Patrick E. Estrela
 * @Data 21/09/20
 */
@RestController
@RequestMapping(value="/api/wa")
@Api(value="API REST EMPRESTIMOS")
@CrossOrigin(origins="*")
@Validated
public class UsuarioResource {
	
	@Autowired
	UsuarioController usuarioController;
	
	@GetMapping("/listarTodosUsuarios")
	@ApiOperation(value="Listar Todos os Usuarios")
	public ResponseEntity<List<UsuarioRespostaDTO>> listarContatos(){
		return new ResponseEntity<List<UsuarioRespostaDTO>>(usuarioController.listarContatos(), HttpStatus.OK);
	}
	
	@PostMapping("/inserirUmUsuario")
	@ApiOperation(value="Inserir apenas 1 usuario")
	public ResponseEntity<UsuarioRespostaDTO> inserirUsusario(@RequestBody UsuarioDTO usuarioNovo){
		return new ResponseEntity<UsuarioRespostaDTO>(usuarioController.salvar(usuarioNovo),HttpStatus.CREATED);
	}
	
	@PostMapping("/inserirVariosUsuario")
	@ApiOperation(value="Inserir apenas varios usuario")
	public ResponseEntity<List<UsuarioRespostaDTO>> inserirUsusarios(@RequestBody List<UsuarioDTO> usuariosNovos){
		return new ResponseEntity<List<UsuarioRespostaDTO>>(usuarioController.salvarLista(usuariosNovos),HttpStatus.CREATED);
	}
	
	@GetMapping("/pesquisa")
	@ApiOperation(value="Inserir apenas varios usuario")
	public ResponseEntity<List<UsuarioRespostaDTO>> getUsuario(@RequestParam(value="nome") String id){
		return new ResponseEntity<List<UsuarioRespostaDTO>>(usuarioController.gerUsuario(id),HttpStatus.OK);
	}
	
	@GetMapping("/{idu}")
	@ApiOperation(value="Inserir apenas varios usuario")
	public ResponseEntity<UsuarioRespostaDTO> getUsuario(@PathVariable(value="idu") long id){
		return new ResponseEntity<UsuarioRespostaDTO>(usuarioController.gerUsuarioId(id),HttpStatus.OK);
	}
}
