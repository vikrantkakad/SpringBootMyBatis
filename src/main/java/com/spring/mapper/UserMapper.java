package com.spring.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.pojo.User;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM users WHERE id = #{id}")
	User retriveById(@Param("id") int id);
	
	@Select("SELECT * FROM users WHERE city = #{city}")
	User findByCity(@Param("city") String city);

	@Options(useGeneratedKeys = true)
	@Insert("INSERT INTO users (name, city) VALUES (#{name}, #{city})")
	int insertUserDetail(User u);

	@Update("UPDATE users SET city = #{city} WHERE id = #{id}")
	int updateUser(User u);

	@Delete("DELETE FROM users WHERE id = #{id}")
	int deleteUserDetails(@Param("id") int id);
}