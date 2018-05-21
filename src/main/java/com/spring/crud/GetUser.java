package com.spring.crud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.ResourceNotFoundException;
import com.spring.mapper.UserMapper;
import com.spring.pojo.User;

@RestController
public class GetUser {

	private UserMapper um;

	public GetUser(UserMapper um) {
		this.um = um;
	}

	@GetMapping("/user/{id}")
	public User read(@PathVariable int id) {
		User u = this.um.retriveById(id);
		if (null == u)
			throw new ResourceNotFoundException("id" + id);
		return u;
	}
}