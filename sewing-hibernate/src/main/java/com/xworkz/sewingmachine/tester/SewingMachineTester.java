package com.xworkz.sewingmachine.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.xworkz.sewingmachine.dao.SewingMachineDAO;
import com.xworkz.sewingmachine.dao.SewingMachineDAOImpl;
import com.xworkz.sewingmachine.dto.SewingMachineDTO;
import com.xworkz.sewingmachine.service.SewingMachineService;
import com.xworkz.sewingmachine.service.SewingMachineServiceImpl;

public class SewingMachineTester {

	public static void main(String[] args) {
		
		
//		SewingMachineDTO dto = new SewingMachineDTO("G-Movers", "G-4001",5000, "Black", true);
		
		SewingMachineService serviceImpl = new  SewingMachineServiceImpl();
//		serviceImpl.validateSewingMachineDTO(dto);
	
	serviceImpl.validateSewingMachineDetails();
	
	
	}

}
