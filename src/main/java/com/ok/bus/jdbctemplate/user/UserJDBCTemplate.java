package com.ok.bus.jdbctemplate.user;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void create(String name, String email, String password, String phoneNumber) {
		String sql = "insert into user (name, email, password, phoneNumber) values (?, ?, ?, ?)";
		jdbcTemplateObject.update(sql, name, email, password, phoneNumber);
		return;
	}

	@Override
	public User getUserByEmail(String email) {
		String sql = "select * from user where email = ?";
		User user = jdbcTemplateObject.queryForObject(sql, new Object[]{email}, new UserMapper());
		return user;
	}
	
	@Override
	public User getUserById(long id) {
		String sql = "select * from user where id = ?";
		User user = jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new UserMapper());
		return user;
	}

	@Override
	public List<User> listUser() {
		String sql = "select * from user";
		List<User> users = jdbcTemplateObject.query(sql, new UserMapper());
		return users;
	}

	@Override
	public void delete(long id) {
		String sql = "delete from user where id = ?";
		jdbcTemplateObject.update(sql, id);
		return;
	}

	@Override
	public void update(long id, String name, String email, String password, String phoneNumber) {
		String sql = "update user set password = ?, phoneNumber = ?, name = ?, email = ? where id = ?";
		jdbcTemplateObject.update(sql, password, phoneNumber, name, email, id);
		return;
	}
	
}
