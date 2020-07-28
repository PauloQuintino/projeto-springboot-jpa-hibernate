package com.pauloquintino.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloquintino.projetojpa.entities.User;
import com.pauloquintino.projetojpa.repositories.UserRepository;

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
		return obj.get();
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public User update(Long id, User obj) {
		// pega uma entidade que vai ser monitorada
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	/* metodo que vai atualizar um objeto de User de acordo com o que foi atualizado
	* na entidade monitorada */
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}

}
