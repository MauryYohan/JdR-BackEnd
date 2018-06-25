package com.jdr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.annotation.JsonView;
import com.jdr.dao.PartieDao;
import com.jdr.entity.Partie;
import com.jdr.entity.Views;


@RestController
@CrossOrigin
public class PersonnageController {
	
	@Autowired	
	PersonnageDao personnageDao;
	
	@GetMapping("/personnages/{id}")
	public ResponseEntity<Partie> findOne(@PathVariable("id") Integer id){
		
		Partie b = personnageDao.findByPrimaryKey(id);
		
		if(b == null) {
			return new ResponseEntity<Partie>(b, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Partie>(b, HttpStatus.OK);
		}
	}
	
	@GetMapping("/personnages")
	public ResponseEntity<List<Partie>> findAll() {
		List<Partie> personnages = personnageDao.findAll();
		return new ResponseEntity<List<Partie>>(personnages, HttpStatus.OK);
	}
	
	@DeleteMapping("/personnages/{id}")
	public ResponseEntity<Partie> delete(@PathVariable("id") Integer id){
		Partie tmp = personnageDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			personnageDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/personnages")
	public ResponseEntity<Partie> create(@Valid @RequestBody Partie personnage) {
		if (personnage.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		personnageDao.save(personnage);
		return new ResponseEntity<Partie>(personnage, HttpStatus.CREATED);
	}
	@PutMapping("/personnages")
	public ResponseEntity<Partie> update(@RequestBody Partie personnage) {
		if (personnage.getId() == 0) {
			return create(personnage);
		}
		personnage = personnageDao.update(personnage);

		return new ResponseEntity<Partie>(personnage, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

}
