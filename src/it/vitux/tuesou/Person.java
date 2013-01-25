package it.vitux.tuesou;



public class Person {
	
    private String name;
    private String date;
    private int deleteTrack;
    private String arrivalTime;
    private String departureTime;
    
    public Person(String name, String date, String departureTime, String arrivalTime, int deleteFriends) {
            
            this.name = name;
            this.date = date;
            this.deleteTrack = deleteTrack;
            this.departureTime = departureTime;
            this.arrivalTime = arrivalTime;
    }
    public String getName() {
            return name;
    }
    public String getDate() {
            return date;
    }
    
    public String getDepartureTime() {
        return departureTime;
}
    
    public String getArrivalTime() {
        return arrivalTime;
}
   
    
    public int getDeleteTrack(){
    	return deleteTrack;
    }
}