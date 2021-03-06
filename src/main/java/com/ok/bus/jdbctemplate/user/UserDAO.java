package com.ok.bus.jdbctemplate.user;

import java.util.List;

import javax.sql.DataSource;

public interface UserDAO {
	public void setDataSource(DataSource ds);
	
	public void create(String name, String email, String password, String phoneNumber);
	
	public User getUserByEmail(String email);
	
	public User getUserById(long id);
	
	public List<User> listUser();
	
	public void delete(long id);
	
	public void update(long id, String name, String email, String password, String phoneNumber);
}
