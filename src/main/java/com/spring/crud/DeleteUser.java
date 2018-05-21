package com.spring.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.InternalServerErrorException;
import com.spring.mapper.UserMapper;

@RestController
public class DeleteUser {

	Logger log = LoggerFactory.getLogger(DeleteUser.class);

	private UserMapper um;

	public DeleteUser(UserMapper um) {
		this.um = um;
	}

	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable int id) {
		int status = um.deleteUserDetails(id);
		if (0 >= status)
			throw new InternalServerErrorException("Unable to delete User Details");

		log.info("User has been successfully deleted!");
		return;
	}
}