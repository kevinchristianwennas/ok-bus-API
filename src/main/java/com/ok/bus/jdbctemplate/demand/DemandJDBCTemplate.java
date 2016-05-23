package com.ok.bus.jdbctemplate.demand;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DemandJDBCTemplate implements DemandDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public Demand create(long userId, boolean rentType, String pickAddress, String destinationAddress, Date departureDate,
			Date returnDate, int status, String contact, String[] facilities) {
		String sql = "insert into demand (userId, rentType, pickAddress, destinationAddress, departureDate, returnDate, status, contact, facilities) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String strFacilities = "";
		for (String facility : facilities) {
			strFacilities += facility+",";
		}
		
		jdbcTemplateObject.update(sql, userId, rentType, pickAddress, destinationAddress, departureDate, returnDate, status, contact, strFacilities);
		
		Demand newCreatedDemand = getDemand(userId, rentType, pickAddress, destinationAddress, departureDate, returnDate, status, contact, strFacilities);
		return newCreatedDemand;
	}
	
	private Demand getDemand(long userId, boolean rentType, String pickAddress, String destinationAddress, Date departureDate,
			Date returnDate, int status, String contact, String facilities) {
		String sql = "select * from demand where userId = ? and rentType = ? and pickAddress like ? and destinationAddress like ? and departureDate = ? and returnDate = ? and status = ? and contact like ? and facilities like ?";
		Demand demand = jdbcTemplateObject.queryForObject(sql, new Object[]{userId, rentType, pickAddress, destinationAddress, departureDate, returnDate, status, contact, facilities}, new DemandMapper());
		return demand;
	}

	@Override
	public Demand getDemand(long id) {
		String sql = "select * from demand where id = ?";
		Demand demand = jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new DemandMapper());
		return demand;
	}

	@Override
	public List<Demand> listDemand(long userId) {
		String sql = "select * from demand where userId = ?";
		List<Demand> demands = jdbcTemplateObject.query(sql, new Object[]{userId}, new DemandMapper());
		return demands;
	}

	@Override
	public void delete(long id) {
		String sql = "update demand set status = ? where id = ?";
		jdbcTemplateObject.update(sql, 3,id);
		return;
	}

	@Override
	public void update(long id, boolean rentType, String pickAddress, String destinationAddress, Date departureDate,
			Date returnDate, int status, String contact, String[] facilities, long choosenOfferId, long finalCost) {
		String sql = "update demand set rentType = ?, pickAddress = ?, destinationAddress = ?, departureDate = ?, returnDate = ?, status = ?, contact = ?, facilities = ?, choosenOfferId = ?, finalCost = ? where id = ?";
		String strFacilities = "";
		for (String facility : facilities) {
			strFacilities += facility+",";
		}
		jdbcTemplateObject.update(sql, rentType, pickAddress, destinationAddress, departureDate, returnDate, status, 
				contact, strFacilities, choosenOfferId, finalCost, id);
		return;
	}

}
