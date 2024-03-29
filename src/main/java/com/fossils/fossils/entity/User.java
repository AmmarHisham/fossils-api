package com.fossils.fossils.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long id;
    
    @Column(name = "User_Name", length = 64, nullable = false)
    private String userName;
 
    @Column(name = "Password", length = 64, nullable = false)
    private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
