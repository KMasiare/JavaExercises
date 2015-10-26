package com.capgemini.taxi;

public class Taxi {
	long id;
	boolean isAvailable;
	Position position;
	
	Taxi(long id, Position position) {
		this.id = id;
		this.position = position;
		isAvailable = true;
	}
}
