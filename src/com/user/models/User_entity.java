package com.user.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User_entity
 *
 */
@Entity

public class User_entity implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public User_entity() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String login;
	private String firstName;
	private String lastName;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
   
}
