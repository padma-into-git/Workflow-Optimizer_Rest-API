package com.spo.model;

public class Structure {
	private int[] rooms;
	private Workforce workforce;
	
	public Structure() {
		
	}
	
	public Structure(int[] rooms, Workforce workforce) {
		this.rooms = rooms;
		this.workforce = workforce;
	}
	public int[] getRooms() {
		return rooms;
	}
	public void setRooms(int[] rooms) {
		this.rooms = rooms;
	}
	public Workforce getWorkforce() {
		return workforce;
	}
	public void setWorkforce(Workforce workforce) {
		this.workforce = workforce;
	}
}
