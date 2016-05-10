package com.ok.bus.jdbctemplate.demand;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

public interface DemandDAO {
	public void setDataSource(DataSource ds);
	
	public Demand create(long userId, boolean rentType, String pickAddress, String destinationAddress,
			Date departureDate, Date returnDate, int status, String contact, String[] facilities);
	
	public Demand getDemand(long id);
	
	public List<Demand> listDemand(long userId);
	
	public void delete(long id);
	
	public void update(long id, boolean rentType, String pickAddress, String destinationAddress,
			Date departureDate, Date returnDate, int status, String contact, String[] facilities, 
			long choosenOfferId, long finalCost);
}
