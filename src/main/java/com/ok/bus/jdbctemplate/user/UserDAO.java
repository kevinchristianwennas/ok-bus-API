package com.ok.bus.jdbctemplate.user;

import java.util.List;

import javax.sql.DataSource;

public interface UserDAO {
	public void setDataSource(DataSource ds);
	
	public void create(String name, String email, String password, String phoneNumber);
	
	public User getUser(String email);
	
	public List<User> listUser();
	
	public void delete(String email);
	
	public void update(String name, String email, String password, String phoneNumber);
}
