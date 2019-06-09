package br.com.tidicas.service;

import java.util.List;

import br.com.tidicas.domain.Blog;

public interface BlogService {
	
	List<Blog> findAll();
	Blog findById(Integer id);	
	void save(Blog blog);
	void update(Blog blog);
	void delete(Integer id);

}