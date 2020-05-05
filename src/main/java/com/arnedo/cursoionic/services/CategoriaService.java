package com.arnedo.cursoionic.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnedo.cursoionic.domain.Categoria;
import com.arnedo.cursoionic.repositories.CategoriaRepository;
import com.arnedo.cursoionic.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		// função expressão lambda -> com costrutor vazio
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	/**
	 * Metodo usado antes da versão 2.x do spring
	 * @param id
	 * @return
	 * @throws ObjectNotFoundException 
	 */
	public Categoria buscar2(Integer id) throws ObjectNotFoundException  {
		Categoria obj = null; //repo.findOne(id);
		if (obj == null ) {
			//throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id + 
					//", Tipo: " + Categoria.class.getName());
			
			throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id + 
					", Tipo: " + Categoria.class.getName());
		}
		return obj;
	}
	
}
