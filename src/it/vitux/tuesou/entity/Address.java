package it.vitux.tuesou.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {

	//
	private String type;
	private String name;
	private String number;

	
	private String address;

	private String city;
	private String state;
	private String zipCode;
	
	public Address() {
	
	}
	
	/**
	 * @param address
	 * @param city
	 * @param state
	 * @param zipCode
	 */
	public Address(String type,String name,String number, String city, String state, String zipCode) {
		this.type= type;
		this.name = name;
		this.number= number;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	
	/**
	 *  @return the type
	 */
	public String getType(){
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type){
		//Check the length of the type
				if(type.length()<=3 || type.length()>=7) {
					throw new IllegalArgumentException("The type must be >3 and <15");
				}
				
				//Check if the type contains only characters
				Pattern p1 = Pattern.compile("^[a-zA-Z]+$");
				Matcher m1 = p1.matcher(type);
				if (!m1.find()) {
					throw new IllegalArgumentException("The type must be in a correct format");
				}		
				
				this.type = type;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		
		//Check the address' lenght
		if(name.length()<=3 || name.length()>=100) {
			throw new IllegalArgumentException("The name must be >7 and <15");
		}
		
		//Check if the name contains only characters
		Pattern p1 = Pattern.compile("^[a-zA-Z]+$");
		Matcher m1 = p1.matcher(name);
		if (!m1.find()) {
			throw new IllegalArgumentException("The name must be in a correct format");
		}	
		
		this.name = name;
	}
	
	/**
	 * @return the number
	 */
	public String getNumber(){
		return number;
	}
	
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number){
		
		//Check if the number contains only characters
		Pattern p1 = Pattern.compile("^[0-9]+$");
		Matcher m1 = p1.matcher(number);
		if (!m1.find()) {
			throw new IllegalArgumentException("The number must be in a correct format");
		}	
		
		this.number = number;
		
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		
		//Check the city's length
		if(city.length()>=30) {
			throw new IllegalArgumentException("The city must be <30");
		}
		
		//Check if the city contains only characters
		Pattern p1 = Pattern.compile("^[a-zA-Z]+$");
		Matcher m1 = p1.matcher(city);
		if (!m1.find()) {
			throw new IllegalArgumentException("The city must be in a correct format");
		}	
		
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		
		//Check the state's length
		if(state.length()>=30) {
			throw new IllegalArgumentException("The state must be <30");
		}
		
		//Check if the state contains only characters
		Pattern p1 = Pattern.compile("^[a-zA-Z]+$");
		Matcher m1 = p1.matcher(state);
		if (!m1.find()) {
			throw new IllegalArgumentException("The state must be in a correct format");
		}	
		
		this.state = state;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		
		//Check the zipcode length
		if(zipCode.length()<3 || zipCode.length()>8) {
			throw new IllegalArgumentException("The zipcode must be <=8");
		}
		
		//Check if the zipcode contains only numbers
		Pattern p1 = Pattern.compile("^[0-9]+$");
		Matcher m1 = p1.matcher(zipCode);
		if (!m1.find()) {
			throw new IllegalArgumentException("The zipcode must be in a correct format");
		}	
		
		this.zipCode = zipCode;
	}

	
}
