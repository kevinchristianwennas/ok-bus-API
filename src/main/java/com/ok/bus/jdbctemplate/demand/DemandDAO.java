package com.ok.bus.jdbctemplate.demand;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

public interface DemandDAO {
	public void setDataSource(DataSource ds);
	
	public void create(long userId, boolean rentType, String pickAddress, String destinationAddress,
			Date departureDate, Date returnDate, int status);
	
	public Demand getDemand(long id);
	
	public List<Demand> listDemand(long userId);
	
	public void delete(long id);
	
	public void update(long id, boolean rentType, String pickAddress, String destinationAddress,
			Date departureDate, Date returnDate, int status, long choosenOfferId, long finalCost);
}
