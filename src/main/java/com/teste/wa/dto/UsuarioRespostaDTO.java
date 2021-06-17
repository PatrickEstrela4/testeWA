package com.teste.wa.dto;

import com.teste.wa.model.Endereco;
import com.teste.wa.model.Usuario;

/**
 * @author Patrick E. Estrela
 * @Data 21/09/20
 */
public class UsuarioRespostaDTO {
	
	private long id;
	private String nome;
	private String email;
	private String senha;
	private Endereco endereco;

	public UsuarioRespostaDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.endereco = usuario.getEndereco();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
