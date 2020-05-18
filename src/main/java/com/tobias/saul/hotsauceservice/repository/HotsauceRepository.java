package com.tobias.saul.hotsauceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobias.saul.hotsauceservice.entity.Hotsauce;

@Repository
public interface HotsauceRepository extends JpaRepository<Hotsauce, Long> {

}
