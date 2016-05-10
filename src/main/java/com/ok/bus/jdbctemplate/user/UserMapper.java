package com.ok.bus.jdbctemplate.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setPhoneNumber(rs.getString("phoneNumber"));
		return user;
	}
	
}
