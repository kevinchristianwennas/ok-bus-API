package com.ok.bus.jdbctemplate.demandbus;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DemandBusMapper implements RowMapper<DemandBus>{

	@Override
	public DemandBus mapRow(ResultSet rs, int rowNumber) throws SQLException {
		DemandBus demandBus = new DemandBus();
		demandBus.setId(rs.getInt("id"));
		demandBus.setDemandId(rs.getInt("demandId"));
		demandBus.setAmount(rs.getInt("amount"));
		demandBus.setBusType(rs.getString("busType"));
		demandBus.setServices(rs.getString("services"));
		demandBus.setUserBudget(rs.getLong("userBudget"));
		return demandBus;
	}

}
