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

import br.com.tidicas.domain.Blog;
import br.com.tidicas.service.BlogService;

@RestController
@RequestMapping("/springboot/blog")
public class BlogController {

  @Autowired
  BlogService blogService;

  @GetMapping
  public ResponseEntity<?> findAll() {
    List<Blog> result = blogService.findAll();
    return new ResponseEntity<Object>(result, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable("id") String id) {
    Blog result = new Blog();
    result = blogService.findById(Integer.parseInt(id));
    return new ResponseEntity<Object>(result, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<?> add(@RequestBody Blog acordoCerto) {
    
    blogService.save(acordoCerto);
    return new ResponseEntity<Object>("Blog adicionado com sucesso", HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<?> update(@RequestBody Blog acordoCerto) {
    blogService.update(acordoCerto);
    return new ResponseEntity<Object>("Blog atualizado com sucesso", HttpStatus.OK);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void delete(@RequestParam("id") Integer id) {
    blogService.delete(id);
  }

}
