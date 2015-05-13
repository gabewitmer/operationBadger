package com.ghoulgotha.badger.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
	public User findOne(Long id) {
		return repo.findOne(id);
	}
	public User save(User user) {
		return repo.save(user);
	}
	public void delete(Long id) {
		repo.delete(id);
	}
	public void delete(User user) {
		repo.delete(user);
	}
	public User findByUsername(String username) {
		return repo.findByUsername(username);
	}

	public Boolean canUpdate(Long id, String username) {
/*		if (id == null) {
			id = 0L;
		}
		int numberOfUsers = repo.canUpdate(id, username);
		return numberOfUsers == 0;*/
		return (repo.canUpdate((id == null) ? 0L : id, username) == 0);
	}
}
