package com.hotelCalifornia.hotelCalifornia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelCalifornia.hotelCalifornia.model.HotelCalifornia;
import com.hotelCalifornia.hotelCalifornia.repository.HotelCaliforniaRepository;

@RestController
@RequestMapping({"/api/contacttura"})

public class HotelCaliforniaController {
	
	private HotelCaliforniaRepository repository;
	
	
	//List all
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	//FindById
	@GetMapping(value = "{id}")
	public ResponseEntity<HotelCalifornia> findById(@PathVariable Long id){
		return repository.findById(id)
		.map(mapping -> ResponseEntity.ok().body(mapping))
		.orElse(ResponseEntity.notFound().build());
	}
	
	//Create
	@PostMapping
	public HotelCalifornia create(@RequestBody HotelCalifornia hotelCalifornia){
		return repository.save(hotelCalifornia);
	}
	
	//Update
	@PutMapping(value = "{id}")
	public ResponseEntity<HotelCalifornia> update (@PathVariable Long id, @RequestBody HotelCalifornia hotelCalifornia){
		return repository.findById(id)
		.map(mapping->{
		mapping.setName(hotelCalifornia.getName());
		mapping.setLocal(hotelCalifornia.getLocal());
		mapping.setCapacidade(hotelCalifornia.getCapacidade());
		
		HotelCalifornia update = repository.save(mapping);
		
		return ResponseEntity.ok().body(update);
		}).orElse(ResponseEntity.notFound().build());
			
	}
	
	//Delete
	@DeleteMapping (path = "/{id}")
	public ResponseEntity <?> delete (@PathVariable Long id){
		return repository.findById(id)
		.map(mapping ->{
			repository.deleteById(id);
			
		return ResponseEntity.ok().body("DELETADO COM SUCESSO");	
		}).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	
	
	

}
