package com.pauloquintino.projetojpa.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.pauloquintino.projetojpa.entities.User;
import com.pauloquintino.projetojpa.repositories.UserRepository;
import com.pauloquintino.projetojpa.services.exceptions.DatabaseException;
import com.pauloquintino.projetojpa.services.exceptions.ResourceNotFoundException;

@Service // --> registra o UserService como service do Spring para poder ser injetado com
			// o Autowired em outras classes
public class UserService {

	// injetando dependencia do User Repository
	@Autowired
	private UserRepository repository;

	// metodo para retornar todos os usuários do banco
	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}

	public User update(Long id, User obj) {
		// pega uma entidade que vai ser monitorada
		try {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	/* metodo que vai atualizar um objeto de User de acordo com o que foi atualizado
	* na entidade monitorada */
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}

}
