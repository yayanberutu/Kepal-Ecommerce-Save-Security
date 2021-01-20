package kepal.kel6.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kepal.kel6.model.User;
import kepal.kel6.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired UserService userService;
	
	@GetMapping("")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
		try {
			User user = userService.getUserByUsername(username);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	 @PutMapping(value = "/update/{id}")
	 public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
		 try {
			 User existUser = userService.getUserById(id);
			 user.setId(id);
			 userService.saveUser(user);
			 return new ResponseEntity<User>(user, HttpStatus.OK);
		 }catch(NoSuchElementException e) {
			 return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		 }
		 
	 }
	 
	 @PostMapping(value="/add")
	 public ResponseEntity<User> createUser(@RequestBody User user){
		 userService.saveUser(user);
		 
		 return new ResponseEntity<User>(user, HttpStatus.OK);
	 }
	 
	 @DeleteMapping(value="/delete/{id}")
	 public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
		 try {
			 User existuser = userService.getUserById(id);
			 userService.deleteUser(id);
			 return new ResponseEntity<String>(HttpStatus.OK);
		 }catch(NoSuchElementException e) {
			 return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @PostMapping("login")
	 public ResponseEntity<User> login(@RequestBody User user){
		 try {
			 User existUser = userService.getUserByEmail(user.getEmail());
			 return new ResponseEntity<User>(user, HttpStatus.OK);
		 }catch(NoSuchElementException e) {
			 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		 }
	 }
	
	
}
