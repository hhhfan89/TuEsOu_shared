package it.vitux.tuesou.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Track implements Serializable{
	
	private int id;
	private String name;
	private Date date;
	private Time startTime;
	private Time finishTime;
	
	public Track(){
		
	}
	
	public Track(int id, String name, Date date, Time startTime, Time finishTime){
		this.id = id;
		this.name = name;
		this.date = date;
		this.startTime = startTime;
		this.finishTime = finishTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		//� un OR perch� � impossibile che ci sia un finishTime senza uno startTime
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
		//� un OR perch� � impossibile che ci sia un finishTime senza uno startTime
		if(finishTime.before(startTime) && startTime == null){
			throw new IllegalArgumentException("The startTime is > than the finishTime");
		}
		
		this.finishTime = finishTime;
	}
	
}
