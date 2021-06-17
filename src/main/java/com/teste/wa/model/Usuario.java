package com.teste.wa.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author Patrick E. Estrela
 * @Data 21/09/20
 */
@Document(collection = "users_db")
public class Usuario {
	


	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long id;
	
	@NotEmpty(message = "O Campo nome é obrigatorio")
	private String nome;
	
	@NotEmpty(message = "O Campo login é obrigatorio")
	@Email
	private String email;
	
	@NotEmpty(message = "O Campo senha é obrigatorio")
	private String senha;
	
	private Endereco endereco;
	
	public Usuario() {
	}

	public Usuario( long id,
					@NotEmpty(message = "O Campo nome é obrigatorio") String nome,
					@NotEmpty(message = "O Campo login é obrigatorio") @Email String email,
					@NotEmpty(message = "O Campo senha é obrigatorio") String senha,
					Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
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
