package com.arnedo.cursoionic.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arnedo.cursoionic.domain.Categoria;
import com.arnedo.cursoionic.services.CategoriaService;
import com.arnedo.cursoionic.services.exceptions.ObjectNotFoundException;


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		List<Categoria> categorias = new ArrayList<>();
		categorias.add(cat1);
		categorias.add(cat2);
		
		return categorias;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		// o ? significa que pode retornar qualquer coisa.
		
		// Os controladores Rest devem ser minimizados... Será colocado um Handler para tratar a exceção
		// para lançar a resposta http 
		// Hadler é um manipulador de exceções dos recursos
		/*
		Categoria obj = null;
		try {
			obj = service.buscar(id);
		} catch (ObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(obj);
		*/
		
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
