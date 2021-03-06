package com.arnedo.cursoionic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.arnedo.cursoionic.domain.Categoria;
import com.arnedo.cursoionic.dto.CategoriaDTO;
import com.arnedo.cursoionic.repositories.CategoriaRepository;
import com.arnedo.cursoionic.services.exceptions.DataIntegrityException;
import com.arnedo.cursoionic.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) throws ObjectNotFoundException {
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
	
	public Categoria insert(Categoria obj) {
		obj.setId(null); //garantindo que o objeto passado seja criado novo e não como uma alteração
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Categoria newObj, Categoria obj) {
		//so atualizar os novos valores do newObj
		newObj.setNome(obj.getNome());
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possíve excluir uma categoria que possui produtos!");
		}
		
	}

	public List<Categoria> findAll() {
		return repo.findAll();
	}
	
	// a contagem de página começa com zero
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		return repo.findAll(PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy));		
	}
	
	public Categoria fromDTO (CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}
}
