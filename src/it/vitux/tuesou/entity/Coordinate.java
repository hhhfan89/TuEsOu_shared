package it.vitux.tuesou.entity;

public class Coordinate{
	
	private double latitude;
	private double longitude;
	
	public Coordinate(){
		
	}
	
	public Coordinate(float latitude, float longitude){
		this.latitude = latitude;
		this.longitude = longitude;
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
