package com.ok.bus;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ok.bus.jdbctemplate.demand.Demand;
import com.ok.bus.jdbctemplate.demand.DemandJDBCTemplate;
import com.ok.bus.jdbctemplate.demandbus.DemandBus;
import com.ok.bus.jdbctemplate.demandbus.DemandBusJDBCTemplate;
import com.ok.bus.jdbctemplate.user.User;
import com.ok.bus.jdbctemplate.user.UserJDBCTemplate;

@RestController
public class Controller {
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate) context.getBean("userJDBCTemplate");
	private DemandJDBCTemplate demandJDBCTemplate = (DemandJDBCTemplate) context.getBean("demandJDBCTemplate");
	private DemandBusJDBCTemplate demandBusJDBCTemplate = (DemandBusJDBCTemplate) context.getBean("demandBusJDBCTemplate");
	
	//////////////////////////////////// THIS LINE BELLOW, API FOR USER ///////////////////////////////////////
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

	//////////////////////////////////// THIS LINE BELLOW, API FOR DEMAND //////////////////////////////////////
	@RequestMapping(value = "/demand", method = RequestMethod.GET)
	public ResponseEntity<List<Demand>> getDaftarPermintaan(@RequestParam(value="userId") int userId) {
		List<Demand> listDemand = demandJDBCTemplate.listDemand(userId);
		if (listDemand != null) {
			for (Demand demand : listDemand) {
				demand.setListOfBus(demandBusJDBCTemplate.listDemandBus(demand.getId()));
			}
			return new ResponseEntity<List<Demand>>(listDemand, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Demand>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/demand/{id}", method = RequestMethod.GET)
	public ResponseEntity<Demand> getPermintaan(@PathVariable int id) {
		Demand demand = demandJDBCTemplate.getDemand(id);
		if (demand != null) {
			demand.setListOfBus(demandBusJDBCTemplate.listDemandBus(demand.getId()));
			return new ResponseEntity<Demand>(demand, HttpStatus.OK);
		} else {
			return new ResponseEntity<Demand>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/demand", method = RequestMethod.POST)
	public ResponseEntity<String> insertDemand(@RequestParam(value="userId") int userId, 
			@RequestParam(value="rentType") boolean rentType, @RequestParam(value="pickAddress") String pickAddress,
			@RequestParam(value="destinationAddress") String destinationAddress, 
			@RequestParam(value="departureDate") Date departureDate, @RequestParam(value="returnDate") Date returnDate,
			@RequestParam(value="status") int status) {
		demandJDBCTemplate.create(userId, rentType, pickAddress, destinationAddress, departureDate, returnDate, status);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/demand", method = RequestMethod.PUT)
	public ResponseEntity<String> updateDemand(@RequestParam(value="userId") int id, 
			@RequestParam(value="rentType") boolean rentType, @RequestParam(value="pickAddress") String pickAddress,
			@RequestParam(value="destinationAddress") String destinationAddress, 
			@RequestParam(value="departureDate") Date departureDate, @RequestParam(value="returnDate") Date returnDate,
			@RequestParam(value="status") int status, @RequestParam(value="choosenOfferId") int choosenOfferId, 
			@RequestParam(value="finalCost") int finalCost) {
		demandJDBCTemplate.update(id, rentType, pickAddress, destinationAddress, departureDate, returnDate, status, choosenOfferId, finalCost);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/demand", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteDemand(@RequestParam(value="id") int id) {
		Demand demand = demandJDBCTemplate.getDemand(id);
		List<DemandBus> listOfBus = demandBusJDBCTemplate.listDemandBus(demand.getId());
		for (DemandBus demandBus : listOfBus) {
			demandBusJDBCTemplate.delete(demandBus.getId());
		}
		demandJDBCTemplate.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
