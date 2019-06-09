package br.com.tidicas.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.tidicas.domain.Blog;

public interface BlogRepository extends CrudRepository<Blog, String>{
	
}