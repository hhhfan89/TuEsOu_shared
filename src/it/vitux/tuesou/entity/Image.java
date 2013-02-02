package it.vitux.tuesou.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Image {
	
	private String address;
	
	public Image(){
		
	}
	
	public Image(String address){
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		
		//Check if the address of image contains the extension
		Pattern p1 = Pattern.compile("^.{1,}\\.jpeg$|^.{1,}\\.jpg$|^.{1,}\\.png$");
		Matcher m1 = p1.matcher(address);
		if (!m1.find()) {
			throw new IllegalArgumentException("The address of image must be in a correct format");
		}	
		
		this.address = address;
	}
	
}

//\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]
