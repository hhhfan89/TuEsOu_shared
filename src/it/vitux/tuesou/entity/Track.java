package it.vitux.tuesou.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Track{
	
	private String name;
	private Date date;
	private Time startTime;
	private Time finishTime;
	private List<Coordinate> coordinate;
	
	public Track(){
	}
	
	public Track(String name, Date date, Time startTime, Time finishTime, List<Coordinate> coordinate){
		this.name = name;
		this.date = date;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.coordinate = coordinate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		
		if(date==null){
			throw new NullPointerException("The date is null.");
		}
		this.date = date;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		
		if(startTime==null){
			throw new NullPointerException("The startTime is null.");
		}
		//è un OR perchè è impossibile che ci sia un finishTime senza uno startTime
		if(startTime.after(finishTime) || finishTime != null){
			throw new IllegalArgumentException("The startTime is > than the finishTime");
		}
		this.startTime = startTime;
	}

	public Time getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Time finishTime) {
		
		if(finishTime==null){
			throw new NullPointerException("The startTime is null.");
		}
		//è un OR perchè è impossibile che ci sia un finishTime senza uno startTime
		if(finishTime.before(startTime) && startTime == null){
			throw new IllegalArgumentException("The startTime is > than the finishTime");
		}
		
		this.finishTime = finishTime;
	}

	public List<Coordinate> getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(List<Coordinate> coordinate) {
		this.coordinate = coordinate;
	}
	
	
	
	
	
	
}
