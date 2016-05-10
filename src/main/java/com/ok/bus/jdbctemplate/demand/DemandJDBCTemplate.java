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
	public void create(long userId, boolean rentType, String pickAddress, String destinationAddress, Date departureDate,
			Date returnDate, int status) {
		String sql = "insert into demand (userId, rentType, pickAddress, destinationAddress, departureDate, returnDate, status) values (?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(sql, userId, rentType, pickAddress, destinationAddress, departureDate, returnDate, status);
		return;
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
		String sql = "delete from demand where id = ?";
		jdbcTemplateObject.update(sql, id);
		return;
	}

	@Override
	public void update(long id, boolean rentType, String pickAddress, String destinationAddress, Date departureDate,
			Date returnDate, int status, long choosenOfferId, long finalCost) {
		String sql = "update demand set rentType = ?, pickAddress = ?, destinationAddress = ?, departureDate = ?, returnDate = ?, status = ?, choosenOfferId = ?, finalCost = ? where id = ?";
		jdbcTemplateObject.update(sql, rentType, pickAddress, destinationAddress, departureDate, returnDate, status, 
				choosenOfferId, finalCost, id);
		return;
	}

}
