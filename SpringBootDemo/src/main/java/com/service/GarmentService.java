package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.GarmentDetail;
import com.entity.GarmentMain;
import com.entity.UsrMain;
import com.repository.GarDetailRepo;
import com.repository.GarMainRepo;
import com.repository.GarmentRepository;
import com.repository.UserRepository;

import UIObject.UsrMainUI;

@Service
public class GarmentService {

	@Autowired
	public GarmentRepository garmentRepo;
	
	public void saveObject(Object object) {
		garmentRepo.saveObject(object);
	}
	
	public Object getObject(long primaryKey,String entityName) {
		return garmentRepo.getObject(primaryKey, entityName);
	}
	
	public List<UsrMain> getAllUsers() {
		return garmentRepo.getAllUsers();
	}
	@Autowired
	private UserRepository userRepository;
	@Autowired
	public GarDetailRepo garDetailRepo;
	@Autowired
	public GarMainRepo garMainRepo;
	
	
	
	public UsrMain getObjectByValue(String userId,String entityName) {
		return userRepository.findByUsername(userId);
	}
	
	public List<GarmentDetail> garmentDetailArray(String userId,String entityName) {
		List<GarmentMain> garmentMainArray = getObjectByValue(userId,entityName).getStrMain().getGarmentMainArray();
		List<GarmentDetail> garMentDetailArray = new ArrayList<>();
		for(GarmentMain garmentMain : garmentMainArray) {
			garMentDetailArray.addAll(garmentMain.getGarmentDetailArray());
		}
		return garMentDetailArray;
	}
	public boolean isValidUser(UsrMainUI usrMainUI) {
		if(usrMainUI.getUserId()==null || usrMainUI.getUserId().equals("") | usrMainUI.getPassword()==null || usrMainUI.getPassword().equals(""))
			return false;
		if(getObjectByValue(usrMainUI.getUserId(), "com.entity.UsrMain")==null)
			return false;
		return getObjectByValue(usrMainUI.getUserId(), "com.entity.UsrMain").getPassword().equals(usrMainUI.getPassword());
		
	}
	
	public void delete(long primaryKey) {
			garDetailRepo.deleteById(primaryKey);
	}
	public GarmentDetail garmentDetail(long primaryKey) {
		return garDetailRepo.findById(primaryKey).get();
	}
	
}
