package it.vitux.tuesou.entity;

import java.io.Serializable;
import java.util.HashSet;

public class Coordinate implements Serializable{
	
	private int id;
	private float latitude;
	private float longitude;
	private Track track;
	
	public Coordinate(){
		
	}
	
	public Coordinate(int id, float latitude, float longitude, Track track){
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.track = track;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
