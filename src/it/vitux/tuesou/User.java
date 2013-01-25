package it.vitux.tuesou;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

	private int id;
	private String username;
	private String name;
	private String surname;
	private String password;
	private String email;
	private String telephone;
	
	public User() {

	}
	
	/**
	 * @param id
	 * @param username
	 * @param name
	 * @param surname
	 * @param password
	 * @param telephone
	 */
	public User(int id, String username, String name, String surname,
			String password, String email, String telephone) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		 
		//Check the length of the username
		if(username.length()<= 4 && username.length()>=12) {
			throw new IllegalArgumentException("The username must be >4 and <12");
		}
		
		//Check if the username is valid trough a regular expression
		Pattern p1 = Pattern.compile("^[A-Za-z0-9_-]$");
		Matcher m1 = p1.matcher(username);
		if (!m1.find()) {
			throw new IllegalArgumentException("The username must be in a correct format");
		}		
		
		this.username = username;
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
		
		//Check the length of the name
		if(name.length()<=3 && name.length()>=15) {
			throw new IllegalArgumentException("The name must be >3 and <15");
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		
		//Check the length of the surname
		if(surname.length()<=3 && surname.length()>=15) {
			throw new IllegalArgumentException("The surname must be >3 and <15");
		}
		
		//Check if the surname contains only characters
		Pattern p1 = Pattern.compile("^[a-zA-Z]+$");
		Matcher m1 = p1.matcher(surname);
		if (!m1.find()) {
			throw new IllegalArgumentException("The surname must be in a correct format");
		}	
		
		this.surname = surname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		
		//Check the password's length
		if(password.length()<= 6 && password.length()>=15) {
			throw new IllegalArgumentException("The password must be >6 and <15");
		}
		
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		
		//Check if the email is valid trough a simple regular expression
		Pattern p1 = Pattern.compile("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
		Matcher m1 = p1.matcher(email);
		if (!m1.find()) {
			throw new IllegalArgumentException("The email must be in a correct format");
		}
		
		this.email = email;
	}
	
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		
		//Check the length of the telephone
		if(telephone.length()>=6 && telephone.length()<=15) {
			throw new IllegalArgumentException("The surname must be >2 and <16");
		}
		
		//Check if the telephone contains only characters
		Pattern p1 = Pattern.compile("^[0-9]+$");
		Matcher m1 = p1.matcher(telephone);
		if (!m1.find()) {
			throw new IllegalArgumentException("The telephone must be in a correct format");
		}	
		
		this.telephone = telephone;
	}
	
}
