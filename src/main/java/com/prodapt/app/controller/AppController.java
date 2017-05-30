package com.prodapt.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.app.dao.UserInformationDao;
import com.prodapt.app.model.AppResponse;
import com.prodapt.app.model.UserInfo;
import com.prodapt.app.model.UserInfoResponse;
import com.prodapt.app.service.AppService;

@RestController
public class AppController {

	@Autowired
	private AppService appService;
	
	@Autowired
	private UserInformationDao userInformationDao;

	public void setEaseYourWorkService(AppService appService) {
		this.appService = appService;
	}

	@RequestMapping(value = "/getAnalysis", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public AppResponse getResult(String appname) {
		return appService.getResult(appname);
	}
	
	@RequestMapping(value = "/setUserInfo", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public boolean insertUserInformation(UserInfo input) {
		boolean isInserted =  userInformationDao.insertUserInformation(input);
		return isInserted;
	}
	
	@RequestMapping(value = "/getUserInfos", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public UserInfoResponse getUserInformation() {
		UserInfoResponse uResponse = new UserInfoResponse();
		uResponse.setUserInfos(userInformationDao.getUserInformation());
		return uResponse;
	}
}
