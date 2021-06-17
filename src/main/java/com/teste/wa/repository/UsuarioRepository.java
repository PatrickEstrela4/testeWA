package com.teste.wa.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teste.wa.model.Usuario;

/**
 * @author Patrick E. Estrela
 * @Data 21/09/20
 */
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Long>{
	
	List<Usuario> findByNome(String nome);
	
	Usuario findById(long nome);
}
