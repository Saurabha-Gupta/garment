package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GARMENT_DETAIL")
public class GarmentDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRIMARY_KEY")
	private long primaryKey;
	@Column(name = "GARMENT_NAME")
	private String garmentName;
	@ManyToOne
	@JoinColumn(name = "FK_GARMENT_MAIN_ID",nullable = false)
	private GarmentMain garmentMain;
	
	public long getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(long primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getGarmentName() {
		return garmentName;
	}
	public void setGarmentName(String garmentName) {
		this.garmentName = garmentName;
	}
	public GarmentMain getGarmentMain() {
		return garmentMain;
	}
	public void setGarmentMain(GarmentMain garmentMain) {
		this.garmentMain = garmentMain;
	}
	
	
	
}
