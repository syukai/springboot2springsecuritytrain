package com.example.sb2train;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb2train.login.Account;
import com.example.sb2train.login.UserRepository;

@RestController
@RequestMapping("bcrypt")
public class BcryptRestController {

	private final UserRepository userRepository;
	BcryptRestController(
			UserRepository userRepository){
		this.userRepository = userRepository;
		
	}
	
	@GetMapping("{word}")
	public String get(@PathVariable("word") String word) {
		BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
		return crypt.encode(word);
	}
	
	@GetMapping
	public List<Account> getAllAccount(){
		return userRepository.findAll();
	}
	
	@GetMapping("user/{user}")
	public Optional<Account> getUser(@PathVariable("user") String user) {
		return userRepository.findByUsername(user);
	}
}
