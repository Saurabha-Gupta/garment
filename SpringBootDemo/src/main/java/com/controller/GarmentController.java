package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.EmployeeEntity;
import com.entity.StrMain;
import com.entity.UsrMain;
import com.service.GarmentService;

import UIObject.UsrMainUI;

@RestController
@RequestMapping("/")
public class GarmentController {

	@Autowired
	public GarmentService garmentService;
	@RequestMapping(method = RequestMethod.POST,value = "/addStore",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StrMain> addStore(@RequestBody StrMain strMain) {
		garmentService.saveObject(strMain);
		return ResponseEntity.ok(strMain);
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/addUser",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsrMain> addUser(@RequestBody UsrMain usrMain) {
		StrMain strMain  = (StrMain)garmentService.getObject(usrMain.getStrMainPk(), "com.entity.StrMain");
		usrMain.setStrMain(strMain);
		garmentService.saveObject(usrMain);
		return ResponseEntity.ok(usrMain);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "testData")
	public String testData(Model model) {
		model.addAttribute("msg", "This is spring boot application.");
		return "test";
	}
	/*
	@RequestMapping(method = RequestMethod.GET,value = "/employeeEntity")
	public ResponseEntity<EmployeeEntity> employeeEntity() {
		return ResponseEntity.ok((EmployeeEntity)garmentService.getObject(1, "com.enitity.EmployeeEntity"));
	}*/
	
}
