package br.com.tidicas.main;

import java.util.Date;
import java.util.logging.Logger;

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

/**
 * @author Evaldo Junior
 * @since 30/03/2019
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude={SecurityAutoConfiguration.class})
public class CreateTabelas {

  @Autowired
  BlogService blogService;
  
  @Autowired
  CategoriaService categoriaService;
  
  final Logger LOG = Logger.getLogger("CreateTabelas");   

  @Test
  public void execute() throws Exception {
    
    // 1 Entidade Categoria
    Categoria c = new Categoria();
    c.setDescricao("categoria new");
    
    categoriaService.save(c);
    
    c = categoriaService.findById(c.getCodigo());
    LOG.info("retorno:" + c.getCodigo());
    
    c.setDescricao("categoria update");
    categoriaService.save(c);
    
    // 2 Entidade Blog
    Blog b = new Blog();
    b.setCategoria(c);
    b.setConteudo("conteúdo teste");
    b.setDtevento(new Date());
    b.setPublicar(1);
    b.setTitulo("título");
    
    blogService.save(b);
    
    b = blogService.findById(b.getCodigo());
    LOG.info("retorno:" + b.getTitulo());

    b.setConteudo("conteúdo teste update");
    b.setDtevento(new Date());
    b.setPublicar(0);
    b.setTitulo("título update");
    
    blogService.save(b);
    
    b = blogService.findById(b.getCodigo());
    LOG.info("retorno:" + b.getTitulo());
    
    categoriaService.delete(c.getCodigo());
    blogService.delete(b.getCodigo());
    LOG.info("delete:" + b.getTitulo());
    
  }

}