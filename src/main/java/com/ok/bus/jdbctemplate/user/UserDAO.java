package com.ok.bus.jdbctemplate.user;

import java.util.List;

import javax.sql.DataSource;

public interface UserDAO {
	public void setDataSource(DataSource ds);
	
	public void create(String username, String password);
	
	public User getUser(String username);
	
	public List<User> listUser();
	
	public void delete(String username);
	
	public void update(String username, String password);
}
