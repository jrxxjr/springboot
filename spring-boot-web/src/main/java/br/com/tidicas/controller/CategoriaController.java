package br.com.tidicas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tidicas.domain.Categoria;
import br.com.tidicas.service.CategoriaService;

@RestController
@RequestMapping("/springboot/categoria")
public class CategoriaController {

  @Autowired
  CategoriaService categoriaService;

  @GetMapping
  public ResponseEntity<?> findAll() {
    List<Categoria> result = categoriaService.findAll();
    return new ResponseEntity<Object>(result, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable("id") String id) {
    Categoria result = new Categoria();
    result = categoriaService.findById(Integer.parseInt(id));
    return new ResponseEntity<Object>(result, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<?> add(@RequestBody Categoria categoria) {
    
    categoriaService.save(categoria);
    return new ResponseEntity<Object>("Blog adicionado com sucesso", HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<?> update(@RequestBody Categoria categoria) {
    categoriaService.update(categoria);
    return new ResponseEntity<Object>("Categoria atualizado com sucesso", HttpStatus.OK);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void delete(@RequestParam("id") Integer id) {
    categoriaService.delete(id);
  }

}