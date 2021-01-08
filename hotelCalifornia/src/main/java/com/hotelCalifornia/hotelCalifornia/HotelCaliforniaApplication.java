package com.hotelCalifornia.hotelCalifornia;

import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hotelCalifornia.hotelCalifornia.model.HotelCalifornia;
import com.hotelCalifornia.hotelCalifornia.repository.HotelCaliforniaRepository;

@SpringBootApplication
public class HotelCaliforniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelCaliforniaApplication.class, args);
	}
	
		@Bean
	//	CommandLineRunner init(HotelCaliforniaRepository repository) {
			//return args ->{
				//repository.deleteAll();
					//LongStream.range(1, 9).mapToObj(i->{
						
						//HotelCalifornia hotel = new HotelCalifornia();
						
						//hotel.setName("Cliente" +i);
						//hotel.setLocal("Olinda");
						//hotel.setCapacidade(1500);
						//return hotel;
				//	})
					
					//.map(m -> repository.save(m))
					//.forEach(System.out::println);
					
					
			//};
		public CommandLineRunner init(@Autowired HotelCaliforniaRepository repository) {
					return args ->{
					
					HotelCalifornia h = HotelCalifornia.builder()
						.name("Hotel California")
						.local("Recife")
						.capacidade(2500)
						.build();
						
					repository.save(h);
				
					};
					}
			
		

	
			
		}
