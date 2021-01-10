package kepal.kel6.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kepal.kel6.model.User;
import kepal.kel6.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired UserRepository userRepo;
	
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	public User getUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public User getUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}
	
	public User getUserById(Long id) {
		return userRepo.findById(id).get();
	}
	
	public void saveUser(User user) {
		userRepo.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
	
	
}
