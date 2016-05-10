package com.ok.bus.jdbctemplate.demandbus;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ok.bus.jdbctemplate.demand.Demand;
import com.ok.bus.jdbctemplate.demand.DemandMapper;

public class DemandBusJDBCTemplate implements DemandBusDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void create(int demandId, String capacity, int amount, long budget) {
		String sql = "insert into demandbus (demandId, capacity, amount, budget) values (?, ?, ?, ?)";
		jdbcTemplateObject.update(sql, demandId, capacity, amount, budget);
		return;
	}

	@Override
	public DemandBus getDemandBus(long id) {
		String sql = "select * from demandbus where id = ?";
		DemandBus demandBus = jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new DemandBusMapper());
		return demandBus;
	}

	@Override
	public List<DemandBus> listDemandBus(long demandId) {
		String sql = "select * from demandbus where demandId = ?";
		List<DemandBus> demandBuses = jdbcTemplateObject.query(sql, new Object[]{demandId}, new DemandBusMapper());
		return demandBuses;
	}

	@Override
	public void delete(long id) {
		String sql = "delete from demandbus where id = ?";
		jdbcTemplateObject.update(sql, id);
		return;
	}

	@Override
	public void update(int demandId, String capacity, int amount, long budget) {
		String sql = "update demandbus set amount = ?, budget = ? where demandId = ? and capacity like ?";
		jdbcTemplateObject.update(sql, amount, budget, demandId, capacity);
		return;
	}

}
