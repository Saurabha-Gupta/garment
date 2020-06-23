package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.ReportAsSingleViolation;

@Entity
@Table(name = "USER_MAIN")
public class UsrMain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRIMARY_KEY")
	private long primaryKey;
	@Column(name = "USER_ID")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name  = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@ManyToOne
	@JoinColumn(name = "FK_STR_MAIN_ID")
	private StrMain strMain;
	
	public long getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(long primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userId) {
		this.username = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public StrMain getStrMain() {
		return strMain;
	}
	public void setStrMain(StrMain strMain) {
		this.strMain = strMain;
	}
	
	
	@Transient private long strMainPk;

	public long getStrMainPk() {
		return strMainPk;
	}
	public void setStrMainPk(long strMainPk) {
		this.strMainPk = strMainPk;
	}
	
	
	
	
}


