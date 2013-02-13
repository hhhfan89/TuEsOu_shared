package it.vitux.tuesou.entity;

public class Coordinate{
	
	private int id;
	private double latitude;
	private double longitude;
	
	public Coordinate(){
		
	}
	
	public Coordinate(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		
		if(latitude<=0){
			throw new IllegalArgumentException("Latitude <= 0");
		}
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		
		if(longitude<=0){
			throw new IllegalArgumentException("Longitude <= 0");
		}
		this.longitude = longitude;
	}


	
}
