package com.xworkz.instagram.tester;

import com.xworkz.instagram.dao.InstagramDAO;
import com.xworkz.instagram.dao.InstagramDAOImpl;
import com.xworkz.instagram.dto.InstagramDTO;
import com.xworkz.instagram.service.InstagramService;
import com.xworkz.instagram.service.InstagramServiceImpl;

public class InstagramTester {

	public static void main(String[] args) {
		
		InstagramDTO dto = new InstagramDTO(400000,9.8, 17, 90000000, true);
		
		InstagramService serviceImpl = new InstagramServiceImpl();
		serviceImpl.validateInstagramDTO(dto);
		
		
		serviceImpl.validateFetchInstagramDetails();
	}

}
