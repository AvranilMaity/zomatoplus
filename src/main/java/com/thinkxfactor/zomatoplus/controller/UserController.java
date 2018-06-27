package com.thinkxfactor.zomatoplus.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thinkxfactor.zomatoplus.models.User;
import com.thinkxfactor.zomatoplus.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired //Inversion of control, Dependency injection
	private UserRepository userRepository;
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		User persistedUser=userRepository.save(user);
		return persistedUser;
	}
	@GetMapping("/getAll")
	public List<User> userList() {
		List<User> listofusers=userRepository.findAll();
		return listofusers;
	}

	@PostMapping("/login")
	public User userLogin(@RequestBody String username,String password) {
		User usr=userRepository.findByNameAndPassword(username,password);
		return usr;
	}
	/*@GetMapping("/all")
	public List<User> userList() {
		List<User> users = new ArrayList<>();
		User usr1,usr2,usr3;
		usr1=new User("Arya","abc123");
		usr2=new User("Sansa","def123");
		usr3=new User("Robb","ghi123");
		users.add(usr1);
		users.add(usr2);
		users.add(usr3);
		return users;
	}*/
	/*@PostMapping("/create")
	public User userCreate(@RequestBody User user) {
		System.out.println(user.toString());
		return user;
	}*/
}
