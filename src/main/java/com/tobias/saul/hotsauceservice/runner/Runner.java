package com.tobias.saul.hotsauceservice.runner;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tobias.saul.hotsauceservice.entity.Hotsauce;
import com.tobias.saul.hotsauceservice.service.HotsauceService;

@Component
public class Runner implements CommandLineRunner{
	
	private final HotsauceService hotsauceService;
	
	public Runner(HotsauceService hotsauceService) {
		this.hotsauceService = hotsauceService;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application is running...");
		
		System.out.println("Adding hot sauce...");
		System.out.println(hotsauceService.addHotsauce(new Hotsauce("hot sauce", 40000, new BigDecimal(3.45).setScale(2, RoundingMode.FLOOR))));
	}

}
