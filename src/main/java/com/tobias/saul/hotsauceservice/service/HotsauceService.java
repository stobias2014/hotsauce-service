package com.tobias.saul.hotsauceservice.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Hotsauce> getAllHotsauces() {
		return hotsauceRepo.findAll();
	}
	
	public Hotsauce updateHotsauce(Hotsauce hotsauce) {
		Optional<Hotsauce> hotsauceInDb = hotsauceRepo.findById(hotsauce.getHotsauceId());
		
		if(hotsauceInDb.isPresent()) {
			return hotsauceRepo.save(hotsauce);
		} else {
			throw new HotsauceNotFoundException(hotsauce.getHotsauceId());
		}
		
	}
	
	
}
