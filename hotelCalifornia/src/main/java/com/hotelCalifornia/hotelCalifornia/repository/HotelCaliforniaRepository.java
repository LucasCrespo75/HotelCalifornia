package com.hotelCalifornia.hotelCalifornia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelCalifornia.hotelCalifornia.model.HotelCalifornia;

@Repository
public interface HotelCaliforniaRepository extends JpaRepository<HotelCalifornia, Long> {

	//Optional <HotelCalifornia> findByCpf(String cpf);

	//void deleteByCpf(String cpf);
	
	

	
	

}
