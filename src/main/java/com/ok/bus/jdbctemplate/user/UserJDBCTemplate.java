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
	public void create(String username, String password) {
		String sql = "insert into user (username, password) values (?, ?)";
		jdbcTemplateObject.update(sql, username, password);
		return;
	}

	@Override
	public User getUser(String username) {
		String sql = "select * from user where username = ?";
		User user = jdbcTemplateObject.queryForObject(sql, new Object[]{username}, new UserMapper());
		return user;
	}

	@Override
	public List<User> listUser() {
		String sql = "select * from user";
		List<User> users = jdbcTemplateObject.query(sql, new UserMapper());
		return users;
	}

	@Override
	public void delete(String username) {
		String sql = "delete from user where username = ?";
		jdbcTemplateObject.update(sql, username);
		return;
	}

	@Override
	public void update(String username, String password) {
		String sql = "update user set password = ? where username = ?";
		jdbcTemplateObject.update(sql, password, username);
		return;
	}
	
}
