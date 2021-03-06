package com.tobias.saul.hotsauceservice.runner;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tobias.saul.hotsauceservice.entity.Hotsauce;
import com.tobias.saul.hotsauceservice.exception.HotsauceNotFoundException;
import com.tobias.saul.hotsauceservice.service.HotsauceService;

@Component
public class Runner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Runner.class);

	private final HotsauceService hotsauceService;

	public Runner(HotsauceService hotsauceService) {
		this.hotsauceService = hotsauceService;
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(("Application is running..."));

		log.info("Adding hot sauces...");
		log.info(hotsauceService
				.addHotsauce(new Hotsauce("hot sauce1", 20000, new BigDecimal(3.45).setScale(2, RoundingMode.FLOOR)))
				.toString());
		log.info(hotsauceService
				.addHotsauce(new Hotsauce("hot sauce2", 40000, new BigDecimal(3.45).setScale(2, RoundingMode.FLOOR)))
				.toString());
		log.info(hotsauceService
				.addHotsauce(new Hotsauce("hot sauce3", 40000, new BigDecimal(3.45).setScale(2, RoundingMode.FLOOR)))
				.toString());
		log.info(hotsauceService
				.addHotsauce(new Hotsauce("hot sauce4", 60000, new BigDecimal(3.45).setScale(2, RoundingMode.FLOOR)))
				.toString());
		log.info(hotsauceService
				.addHotsauce(new Hotsauce("hot sauce5", 80000, new BigDecimal(3.45).setScale(2, RoundingMode.FLOOR)))
				.toString());

		log.info("Retrieving hot sauce...");
		log.info(hotsauceService.getHotsauce(1L).toString());

		log.info("Retrieving hot sauce that does not exist");

		try {
			log.info(hotsauceService.getHotsauce(99L).toString());
		} catch (HotsauceNotFoundException ex) {
			log.info(ex.getMessage());
		}

		log.info("Retrieving all hot sauces...");
		hotsauceService.getAllHotsauces().forEach(hotsauce -> log.info(hotsauce.toString()));

		log.info("Updating a hot sauce in database...");
		log.info(hotsauceService.updateHotsauce(
				new Hotsauce(1L, "updated hot sauce", 40000, new BigDecimal(3.45).setScale(2, RoundingMode.FLOOR)))
				.toString());

		log.info("Retrieving hot sauce by name...");
		try {
			log.info(hotsauceService.getHotsauceByName("hot sauce2").toString());
		} catch (HotsauceNotFoundException ex) {
			ex.getMessage();
		}

		log.info("Retrieving list of hot sauces in a scoville level range...");
		hotsauceService.getHotSauceInRangeofScoville(40000, 80000).forEach(hotsauce -> log.info(hotsauce.toString()));

	}

}
