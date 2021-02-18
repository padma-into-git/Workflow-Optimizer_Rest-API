package com.spo.model;

public class Workforce {
	private int seniorCleaners;
	private int juniorCleaners;
	private String status;
	private String errorMessage;
	
	public Workforce(){
		
	}
    public Workforce(int seniorStaff, int juniorStaff){
        this.seniorCleaners = seniorStaff;
        this.juniorCleaners = juniorStaff;
    }
    
	public int getSeniorCleaners() {
		return seniorCleaners;
	}
	public void setSeniorCleaners(int seniorCleaners) {
		this.seniorCleaners = seniorCleaners;
	}
	public int getJuniorCleaners() {
		return juniorCleaners;
	}
	public void setJuniorCleaners(int juniorCleaners) {
		this.juniorCleaners = juniorCleaners;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
