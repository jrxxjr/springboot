package br.com.tidicas.service;

import java.util.List;

import br.com.tidicas.domain.Categoria;

public interface CategoriaService {
	
	List<Categoria> findAll();
	Categoria findById(Integer id);	
	void save(Categoria blog);
	void update(Categoria blog);
	void delete(Integer id);

}