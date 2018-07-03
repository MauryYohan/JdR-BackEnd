package com.jdr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.jdr.dao.PersonnageDao;
import com.fasterxml.jackson.annotation.JsonView;
import com.jdr.entity.Personnage;



@RestController
@CrossOrigin
public class PersonnageController {
	
	@Autowired	
	PersonnageDao personnageDao;
	
	@GetMapping("/personnages/{id}")
	@JsonView(com.jdr.entity.Views.PersonnageWithEverything.class)
	@CrossOrigin
	public ResponseEntity<Personnage> findOne(@PathVariable("id") Integer id){
		
		Personnage b = personnageDao.findByPrimaryKey(id);
		
		if(b == null) {
			return new ResponseEntity<Personnage>(b, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Personnage>(b, HttpStatus.OK);
		}
	}
	
	@GetMapping("/personnages")
	@JsonView(com.jdr.entity.Views.PersonnageWithEverything.class)
	@CrossOrigin
	public ResponseEntity<List<Personnage>> findAll() {
		List<Personnage> personnages = personnageDao.findAll();
		return new ResponseEntity<List<Personnage>>(personnages, HttpStatus.OK);
	}
	
	@DeleteMapping("/personnages/{id}")
	@JsonView(com.jdr.entity.Views.PersonnageWithEverything.class)
	@CrossOrigin
	public ResponseEntity<Personnage> delete(@PathVariable("id") Integer id){
		Personnage tmp = personnageDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			personnageDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/personnages")
	@JsonView(com.jdr.entity.Views.PersonnageWithEverything.class)
	@CrossOrigin
	public ResponseEntity<Personnage> create(@Valid @RequestBody Personnage personnage) {
		if (personnage.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		personnageDao.save(personnage);
		return new ResponseEntity<Personnage>(personnage, HttpStatus.CREATED);
	}
	@PutMapping("/personnages")
	@JsonView(com.jdr.entity.Views.PersonnageWithEverything.class)
	@CrossOrigin
	public ResponseEntity<Personnage> update(@RequestBody Personnage personnage) {
		if (personnage.getId() == 0) {
			return create(personnage);
		}
		personnage = personnageDao.update(personnage);

		return new ResponseEntity<Personnage>(personnage, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    @CrossOrigin
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

}
