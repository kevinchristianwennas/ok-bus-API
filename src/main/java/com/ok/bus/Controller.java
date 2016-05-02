package com.ok.bus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ok.bus.jdbctemplate.user.User;
import com.ok.bus.jdbctemplate.user.UserJDBCTemplate;

@RestController
public class Controller {
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate) context.getBean("userJDBCTemplate");
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@RequestParam(value="email") String email) {
		User user = userJDBCTemplate.getUser(email);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<String> insertUser(@RequestParam(value="email") String email, 
			@RequestParam(value="name") String name, @RequestParam(value="password") String password,
			@RequestParam(value="phoneNumber") String phoneNumber) {
		userJDBCTemplate.create(name, email, password, phoneNumber);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/permintaan", method = RequestMethod.POST)
	public ResponseEntity<String> getPermintaan(@RequestParam(value="id") int id) {
		return new ResponseEntity<String>(""+id, HttpStatus.ACCEPTED);
	}
}
