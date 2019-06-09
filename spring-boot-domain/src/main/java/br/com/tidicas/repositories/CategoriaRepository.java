package br.com.tidicas.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.tidicas.domain.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, String>{
	
}