package br.com.tidicas;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tidicas.domain.Blog;
import br.com.tidicas.domain.Categoria;
import br.com.tidicas.service.BlogService;
import br.com.tidicas.service.CategoriaService;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
public class ApplicationTests {

  @Autowired
  BlogService blogService;
  CategoriaService categoriaService;

  @Test
  public void testAll() throws Exception {
    List<Blog> blogList = (List<Blog>) blogService.findAll();
    List<Categoria> categoriaList = (List<Categoria>) categoriaService.findAll();
    assertNotNull(blogList);
    assertFalse(blogList.isEmpty());
    assertNotNull(categoriaList);
    assertFalse(categoriaList.isEmpty());
  }

  @Test
  public void testFindById() throws Exception {
    Blog b1 = blogService.findById(1);
    Categoria c1 = categoriaService.findById(1);
    assertNotNull(c1);
    assertEquals(new Integer(1), c1.getCodigo());
    assertNotNull(b1);
    assertEquals(new Integer(1), b1.getCodigo());
    
  }

  @Test
  public void testAdd() throws Exception {
    final String CONTEUDO = "conteudo";
    
    Categoria categoria = new Categoria();
    categoria.setCodigo(1);
    categoria.setDescricao("categoria"+categoria.getCodigo());
    categoriaService.save(categoria);
    
    Blog blog = new Blog();
    blog.setCodigo(1);
    blog.setConteudo(CONTEUDO);
    blog.setDtevento(new Date());
    blog.setContador(1);
    blog.setPublicar(1);
    blog.setTitulo("Titulo");
    blogService.save(blog);

    Blog resultBlog = blogService.findById(1);
    Categoria resultCategoria = categoriaService.findById(1);
    assertNotNull(resultCategoria);
    assertEquals(CONTEUDO, resultCategoria.getDescricao());
    assertNotNull(resultBlog);
    assertEquals(CONTEUDO, resultBlog.getConteudo());
  }

  @Test
  public void testUpdate() throws Exception {
    final String BLOG = "conteudo update";
    final String CATEGORIA = "descricao update";

    Categoria categoria = categoriaService.findById(1);    
    categoria.setDescricao(CATEGORIA+categoria.getCodigo());
    
    categoriaService.save(categoria);

    Categoria categoriaResult = categoriaService.findById(1);
    assertNotNull(categoriaResult);
    assertEquals(BLOG, categoriaResult.getDescricao());
    
    Blog blog = blogService.findById(1);    
    blog.setConteudo(BLOG);
    
    blogService.save(blog);

    Blog result = blogService.findById(1);
    assertNotNull(result);
    assertEquals(BLOG, result.getConteudo());
  }
  
  @Test
  public void testDelete() throws Exception {
    
    Blog blog = blogService.findById(1);    
    
    blogService.delete(blog.getCodigo());

    Blog result = blogService.findById(1);
    assertNull(result);
    
  }

}