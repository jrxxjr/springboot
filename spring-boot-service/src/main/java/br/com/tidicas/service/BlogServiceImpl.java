package br.com.tidicas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tidicas.domain.Blog;
import br.com.tidicas.repositories.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

  @Autowired
  BlogRepository blogRepository;

  @Override
  public Blog findById(Integer id) {
    Optional<Blog> optional = blogRepository.findById(id.toString());
    return optional.get();
  }

  @Override
  public List<Blog> findAll() {
    return (List<Blog>) blogRepository.findAll();
  }

  @Override
  public void save(Blog acordoCerto) {
    blogRepository.save(acordoCerto);
  }

  @Override
  public void update(Blog acordoCerto) {
    blogRepository.save(acordoCerto);
  }

  @Override
  public void delete(Integer id) {    
    blogRepository.delete(blogRepository.findById(id.toString()).get());
  }

}