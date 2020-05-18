package com.tobias.saul.hotsauceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobias.saul.hotsauceservice.entity.Hotsauce;
import com.tobias.saul.hotsauceservice.exception.HotsauceNotFoundException;
import com.tobias.saul.hotsauceservice.repository.HotsauceRepository;

@Service
public class HotsauceService {
	
	private final HotsauceRepository hotsauceRepo;
	
	@Autowired
	public HotsauceService(HotsauceRepository hotsauceRepo) {
		this.hotsauceRepo = hotsauceRepo;
	}
	
	public Hotsauce addHotsauce(Hotsauce hotsauce) {
		return hotsauceRepo.save(hotsauce);
	}
	
	public Hotsauce getHotsauce(Long hotsauceId) {
		return hotsauceRepo.findById(hotsauceId).orElseThrow(() -> new HotsauceNotFoundException(hotsauceId));
	}
	
	
}
