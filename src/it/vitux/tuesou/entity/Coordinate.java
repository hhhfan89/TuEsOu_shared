package it.vitux.tuesou.entity;

public class Coordinate{
	
	private float latitude;
	private float longitude;
	private Track track;
	
	public Coordinate(){
		
	}
	
	public Coordinate(float latitude, float longitude, Track track){
		this.latitude = latitude;
		this.longitude = longitude;
		this.track = track;
	}
	
	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		
		if(latitude<=0){
			throw new IllegalArgumentException("Latitude <= 0");
		}
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		
		if(longitude<=0){
			throw new IllegalArgumentException("Longitude <= 0");
		}
		this.longitude = longitude;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	
}
