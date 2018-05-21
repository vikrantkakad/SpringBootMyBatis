package com.spring.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.InternalServerErrorException;
import com.spring.mapper.UserMapper;
import com.spring.pojo.User;

@RestController
public class AddUser {

	Logger log = LoggerFactory.getLogger(AddUser.class);

	private UserMapper um;

	public AddUser(UserMapper um) {
		this.um = um;
	}

	@PostMapping("/user")
	public User add(@RequestBody User u) {
		um.insertUserDetail(u);

		if (null == u.getId() || 0 > u.getId())
			throw new InternalServerErrorException("Unable to Add User Details in Database");

		log.info("User added sucessfully with id:" + u.getId());
		return u;
	}
}