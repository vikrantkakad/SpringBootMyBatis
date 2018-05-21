package com.spring.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.InternalServerErrorException;
import com.spring.mapper.UserMapper;
import com.spring.pojo.User;

@RestController
public class UpdateUser {

	Logger log = LoggerFactory.getLogger(UpdateUser.class);

	private UserMapper um;

	public UpdateUser(UserMapper um) {
		this.um = um;
	}

	@PutMapping("/user/{id}")
	public User update(@PathVariable int id, @RequestBody User u) {
		u.setId(id);
		int status = um.updateUser(u);

		if (0 >= status)
			throw new InternalServerErrorException("Unable to update User Details");

		log.info("City has been updated sucessfully for User:" + u.getId());
		return u;
	}
}