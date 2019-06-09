package br.com.tidicas.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe para implementar a tabela categoria no banco de dados 
 * 
 * @author Evaldo Junior
 */
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {

   
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer codigo;
	private String descricao;
	private static final long serialVersionUID = 1L;
    
	public Categoria() {
		super();
	}   
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	   
}