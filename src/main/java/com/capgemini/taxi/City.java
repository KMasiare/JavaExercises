package com.capgemini.taxi;

import java.util.ArrayList;
import java.util.List;

public class City {
	long nOfTaxis;
	Position clientPosition;
	List<Taxi> taxiList = new ArrayList<Taxi>();
	
	List<Taxi> findClosestTaxis() {
		List<Taxi> closestTaxis = new ArrayList<Taxi>();
		for(int i = 0; i < taxiList.size(); i++) {
			double distance = countDistance(taxiList.get(i));
			if(distance < 1000) {
				closestTaxis.add(taxiList.get(i));
			}
		}
		return closestTaxis;
	}
	
	double countDistance(Taxi taxi) {
		return Math.sqrt((taxi.position.getX() - clientPosition.getX()) * (taxi.position.getX() - clientPosition.getX())
				+ (taxi.position.getY() - clientPosition.getY()) * (taxi.position.getY() - clientPosition.getY()));
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
