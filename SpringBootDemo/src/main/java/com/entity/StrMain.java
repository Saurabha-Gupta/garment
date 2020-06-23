package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STORE_MAIN")
public class StrMain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRIMARY_KEY")
	private long primaryKey;
	@Column(name = "IDEN_NO")
	private String idenNo;
	@Column(name = "STORE_NAME")
	private String storeName;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "CITY")
	private String city;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "PIN_CODE")
	private String pinCode;
	@Column(name = "CONTACT_NUM")
	private String contactNum;
	@OneToMany(mappedBy = "strMain",cascade = CascadeType.ALL)
	private List<UsrMain> usrMainArray;
	@OneToMany(mappedBy = "strMain",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<GarmentMain> garmentMainArray;
	public long getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(long primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getIdenNo() {
		return idenNo;
	}
	public void setIdenNo(String idenNo) {
		this.idenNo = idenNo;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public List<UsrMain> getUsrMainArray() {
		return usrMainArray;
	}
	public void setUsrMainArray(List<UsrMain> usrMainArray) {
		this.usrMainArray = usrMainArray;
	}
	public List<GarmentMain> getGarmentMainArray() {
		return garmentMainArray;
	}
	public void setGarmentMainArray(List<GarmentMain> garmentMainArray) {
		this.garmentMainArray = garmentMainArray;
	}
	
	
	
	

}
