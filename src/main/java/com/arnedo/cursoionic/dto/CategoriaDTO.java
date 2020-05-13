package com.arnedo.cursoionic.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.Length;

import com.arnedo.cursoionic.domain.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	//@Length(min = 5,max = 80, message = "O tamanho deve ser entre 5 e oitenta caracteres")
	@Size(min = 5, max = 80, message = "O tamanho deve ser entre 5 e oitenta caracteres")
	private String nome;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
