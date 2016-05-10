package com.ok.bus.jdbctemplate.demand;

import java.sql.Date;
import java.util.List;

import com.ok.bus.jdbctemplate.demandbus.DemandBus;

public class Demand {
	private long id;
	private long userId;
	private boolean rentType;
	private String pickAddress;
	private String destinationAddress;
	private Date departureDate;
	private Date returnDate;
	private int status;
	private long choosenOfferId;
	private long finalCost;
	private Date createdDate;
	private List<DemandBus> listOfBus;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public boolean isRentType() {
		return rentType;
	}
	public void setRentType(boolean rentType) {
		this.rentType = rentType;
	}
	public String getPickAddress() {
		return pickAddress;
	}
	public void setPickAddress(String pickAddress) {
		this.pickAddress = pickAddress;
	}
	public String getDestinationAddress() {
		return destinationAddress;
	}
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getChoosenOfferId() {
		return choosenOfferId;
	}
	public void setChoosenOfferId(long choosenOfferId) {
		this.choosenOfferId = choosenOfferId;
	}
	public long getFinalCost() {
		return finalCost;
	}
	public void setFinalCost(long finalCost) {
		this.finalCost = finalCost;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public List<DemandBus> getListOfBus() {
		return listOfBus;
	}
	public void setListOfBus(List<DemandBus> listOfBus) {
		this.listOfBus = listOfBus;
	}
}
