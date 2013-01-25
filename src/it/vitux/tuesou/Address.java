package it.vitux.tuesou;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {

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
	public Address(String address, String city, String state, String zipCode) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		
		//Check the address' lenght
		if(address.length()>=100) {
			throw new IllegalArgumentException("The address must be >7 and <15");
		}
		
		this.address = address;
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
		if(zipCode.length()>8) {
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
