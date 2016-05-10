package com.ok.bus.jdbctemplate.demandbus;

import java.util.List;
import javax.sql.DataSource;

public interface DemandBusDAO {
	public void setDataSource(DataSource ds);
	
	public void create(int demandId, String capacity, int amount, long budget);
	
	public DemandBus getDemandBus(long id);
	
	public List<DemandBus> listDemandBus(long demandId);
	
	public void delete(long id);
	
	public void update(int id, String capacity, int amount, long budget);
}
