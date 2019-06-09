package br.com.tidicas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tidicas.domain.Categoria;
import br.com.tidicas.repositories.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

  @Autowired
  CategoriaRepository categoriaRepository;

  @Override
  public Categoria findById(Integer id) {
    Optional<Categoria> optional = categoriaRepository.findById(id.toString());
    return optional.get();
  }

  @Override
  public List<Categoria> findAll() {
    return (List<Categoria>) categoriaRepository.findAll();
  }

  @Override
  public void save(Categoria acordoCerto) {
    categoriaRepository.save(acordoCerto);
  }

  @Override
  public void update(Categoria acordoCerto) {
    categoriaRepository.save(acordoCerto);
  }

  @Override
  public void delete(Integer id) {    
    categoriaRepository.delete(categoriaRepository.findById(id.toString()).get());
  }

}