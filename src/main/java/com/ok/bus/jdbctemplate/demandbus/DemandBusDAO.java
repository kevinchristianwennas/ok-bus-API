package com.ok.bus.jdbctemplate.demandbus;

import java.util.List;
import javax.sql.DataSource;

public interface DemandBusDAO {
	public void setDataSource(DataSource ds);
	
	public void create(int demandId, String busType, int amount, String services, long userBudget);
	
	public DemandBus getDemandBus(long id);
	
	public List<DemandBus> listDemandBus(long demandId);
	
	public void delete(long id);
	
	public void update(int id, String busType, int amount, String services, long userBudget);
}
