package com.tobias.saul.hotsauceservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tobias.saul.hotsauceservice.entity.Hotsauce;

@Repository
public interface HotsauceRepository extends JpaRepository<Hotsauce, Long> {
	
	public Optional<Hotsauce> findByName(String name);
	@Query("SELECT h FROM Hotsauce h WHERE h.scovilleLevel BETWEEN ?1 AND ?2")
	public List<Hotsauce> findInRangeOfScoville(int scoville1, int scoville2);

}
