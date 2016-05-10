package com.ok.bus.jdbctemplate.demand;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DemandMapper implements RowMapper<Demand>{

	@Override
	public Demand mapRow(ResultSet rs, int rowNum) throws SQLException {
		Demand demand = new Demand();
		demand.setId(rs.getInt("id"));
		demand.setUserId(rs.getInt("userId"));
		demand.setRentType(rs.getBoolean("rentType"));
		demand.setPickAddress(rs.getString("pickAddress"));
		demand.setDestinationAddress(rs.getString("destinationAddress"));
		demand.setDepartureDate(rs.getDate("departureDate"));
		demand.setReturnDate(rs.getDate("returnDate"));
		demand.setStatus(rs.getInt("status"));
		demand.setChoosenOfferId(rs.getInt("choosenOfferId"));
		demand.setFinalCost(rs.getLong("finalCost"));
		demand.setCreatedDate(rs.getDate("createdDate"));
		return demand;
	}

}
