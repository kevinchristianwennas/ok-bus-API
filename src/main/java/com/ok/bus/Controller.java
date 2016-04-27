package com.ok.bus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<String> userLogin(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
		User user = userJDBCTemplate.getUser(username);
		if (user.getPassword().equals(password)) {
			return new ResponseEntity<String>("User: "+username+" logged in.", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("User: "+username+" not found or wrong password.", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/permintaan", method = RequestMethod.POST)
	public ResponseEntity<String> getPermintaan(@RequestParam(value="id") int id) {
		return new ResponseEntity<String>(""+id, HttpStatus.ACCEPTED);
	}
}
