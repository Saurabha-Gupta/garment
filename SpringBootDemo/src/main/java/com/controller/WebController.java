package com.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.GarmentDetail;
import com.entity.GarmentMain;
import com.entity.StrMain;
import com.entity.UsrMain;
import com.service.GarmentService;
import com.service.UserPrincipal;

import UIObject.GarDetailUI;

@Controller
@RequestMapping("/")
public class WebController {

	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	@Autowired
	GarmentService service;
	@RequestMapping("/displayUsers")
	public String displayUsers(Model model) {
		List<UsrMain> usrMainArray = service.getAllUsers();
		System.out.println(usrMainArray.size() +" Size Of User ####");
				model.addAttribute("usersArray", usrMainArray);
		return "UserDetail";
	}

	@RequestMapping("/")
	public String userDetail(Model model,HttpSession httpSession) {
		/*System.out.println(" ##### Calling userDetail page ###### ");
		UserPrincipal userPrincipal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("garmentDetailArray", service.garmentDetailArray(userPrincipal.getUsername(), "com.entity.UsrMain"));
		return "GarmentDetail";*/
		return "Dashboard";
	}
	@RequestMapping("/login")
	public String userLogin() {
		return "UserLogin";
	}
	@RequestMapping("logout")
	public String logout() {
		return "UserLogout";
	}
/*	@RequestMapping("/login")
	public String login(Model model,@ModelAttribute UsrMainUI usrMain,HttpSession httpSession) {
		System.out.println("############# Calling Login Method ################");
		if(httpSession.getAttribute("usrMain")!=null) {
			usrMain = (UsrMainUI)httpSession.getAttribute("usrMain");
		}
		if(service.isValidUser(usrMain)==false) {
			model.addAttribute("error", true);
			return "UserLogin";
		}
		httpSession.setAttribute("usrMain", usrMain);
		model.addAttribute("garmentDetailArray", service.garmentDetailArray(usrMain.getUserId(), "com.entity.UsrMain"));
		return "GarmentDetail";
	}*/
	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}
	
	@RequestMapping(value = "/AddUser")
	public String addUser(Model model) {
		model.addAttribute("usrMain", new UsrMain());
		return "AddUser";
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/createUser")
	public String createUser(UsrMain usrMain) {
		System.out.println("Calling create Method ##########");
		return "";
	}

	@RequestMapping(method = RequestMethod.GET,value = "/delete/{primaryKey}")
	public String delete(@PathVariable String primaryKey,Model model,HttpSession httpSession,HttpServletRequest httpServletRequest) {
		service.delete(Long.parseLong(primaryKey));	
		UserPrincipal userPrincipal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("garmentDetailArray", service.garmentDetailArray(userPrincipal.getUsername(), "com.entity.UsrMain"));
		return "GarmentDetail";
	}
	/*@RequestMapping(method = RequestMethod.GET,value = "addGarDetail")
	public String addGarDetail(@ModelAttribute GarDetailUI garDetailUI) {
		GarmentDetail garmentDetail = new GarmentDetail();
		garmentDetail.setGarmentName(garDetailUI.getGarmentName());
		return "GarmentDetail";
	}*/
	@RequestMapping(method = RequestMethod.POST,value = "/editGarDetail/{primaryKey}")
	public String editGarDetail(@PathVariable String primaryKey,Model model,@ModelAttribute GarDetailUI garDetailUI) {
		GarmentDetail garmentDetail = service.garmentDetail(Integer.parseInt(primaryKey));
		GarmentMain garmentMain = garmentDetail.getGarmentMain();
		garmentDetail.setGarmentName(garDetailUI.getGarmentName());
		garmentMain.setDepartmentType(garDetailUI.getDepartmentType());
		UserPrincipal userPrincipal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		service.garmentRepo.saveObject(garmentDetail);
		service.garmentRepo.saveObject(garmentMain);
		model.addAttribute("garmentDetailArray", service.garmentDetailArray(userPrincipal.getUsername(), "com.entity.UsrMain"));
		return "GarmentDetail";
	}
	@RequestMapping(method = RequestMethod.POST,value = "/addNewGarment")
	public String addNewGarment(@ModelAttribute GarDetailUI garDetailUI,Model model) {
		UserPrincipal userPrincipal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userPrincipal.getUsername();
		StrMain strMain = service.getObjectByValue(userName, "XXXX").getStrMain();
		GarmentMain garmentMain = new GarmentMain();
		garmentMain.setStrMain(strMain);
		strMain.getGarmentMainArray().add(garmentMain);
		garmentMain.setDepartmentType(garDetailUI.getDepartmentType());
		GarmentDetail garmentDetail = new GarmentDetail();
		garmentDetail.setGarmentName(garDetailUI.getGarmentName());
		garmentMain.getGarmentDetailArray().add(garmentDetail);
		garmentDetail.setGarmentMain(garmentMain);
		service.garMainRepo.save(garmentMain);
		model.addAttribute("garmentDetailArray", service.garmentDetailArray(userPrincipal.getUsername(), "com.entity.UsrMain"));
		return "GarmentDetail";
	}
	@RequestMapping("/populateModal/{garmentDetailPk}")
	public String populateModal(Model model,@PathVariable String garmentDetailPk) {
		UserPrincipal userPrincipal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Calling populateModal "+garmentDetailPk);
		GarmentDetail garmentDetail = service.garDetailRepo.findById(Long.parseLong(garmentDetailPk)).get();
		System.out.println(garmentDetail.getPrimaryKey()+" garmentDetail DB ################");
		model.addAttribute("garmentDetail", garmentDetail);
		model.addAttribute("garmentDetailArray", service.garmentDetailArray(userPrincipal.getUsername(), "com.entity.UsrMain"));
		return "modal/garmentDetail :: modalContents";
	}
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "Dashboard";
	}
	@RequestMapping("/shirt")
	public String shirt() {
		return "Shirt";
	}
	
}
