package com.spring.crud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.ResourceNotFoundException;
import com.spring.mapper.UserMapper;
import com.spring.pojo.User;

@RestController
public class SearchUser {

	private UserMapper um;

	public SearchUser(UserMapper um) {
		this.um = um;
	}

	@GetMapping("/user")
	public User read(@RequestParam(value = "city") String city) {
		User u = this.um.findByCity(city);
		if (null == u)
			throw new ResourceNotFoundException("city" + city);
		return u;
	}
}