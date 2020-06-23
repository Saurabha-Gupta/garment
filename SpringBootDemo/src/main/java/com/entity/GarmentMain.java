package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GARMENT_MAIN")
public class GarmentMain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRIMARY_KEY")
	private long primaryKey;
	@Column(name = "DEPARTMENT_TYPE")
	private String departmentType;//ADULT GENTS,ADULT LADIES,LADIES CHILD,GENTS CHILD
	@JoinColumn(name = "FK_STR_MAIN_ID")
	@ManyToOne
	private StrMain strMain;
	@OneToMany(mappedBy = "garmentMain",cascade = CascadeType.ALL)
	private List<GarmentDetail> garmentDetailArray = new ArrayList<GarmentDetail>();
	
	public long getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(long primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getDepartmentType() {
		return departmentType;
	}
	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}
	public List<GarmentDetail> getGarmentDetailArray() {
		return garmentDetailArray;
	}
	public void setGarmentDetailArray(List<GarmentDetail> garmentDetailArray) {
		this.garmentDetailArray = garmentDetailArray;
	}
	public StrMain getStrMain() {
		return strMain;
	}
	public void setStrMain(StrMain strMain) {
		this.strMain = strMain;
	}
	
	
	

}
