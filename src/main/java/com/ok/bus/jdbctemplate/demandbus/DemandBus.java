package com.ok.bus.jdbctemplate.demandbus;

public class DemandBus {
	private int id;
	private int demandId;
	private String busType;
	private int amount;
	private String services;
	private long userBudget;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDemandId() {
		return demandId;
	}
	public void setDemandId(int demandId) {
		this.demandId = demandId;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public long getUserBudget() {
		return userBudget;
	}
	public void setUserBudget(long userBudget) {
		this.userBudget = userBudget;
	}
}
