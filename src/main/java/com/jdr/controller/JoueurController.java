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
import com.jdr.dao.JoueurDao;
import com.jdr.entity.Joueur;
import com.jdr.entity.Views;


@RestController
@CrossOrigin
public class JoueurController {
	
	@Autowired	
	JoueurDao joueurDao;
	
	@GetMapping("/joueurs/{id}")
	public ResponseEntity<Joueur> findOne(@PathVariable("id") Integer id){
		
		Joueur b = joueurDao.findByPrimaryKey(id);
		
		if(b == null) {
			return new ResponseEntity<Joueur>(b, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Joueur>(b, HttpStatus.OK);
		}
	}
	
	@GetMapping("/joueurs")
	public ResponseEntity<List<Joueur>> findAll() {
		List<Joueur> joueurs = joueurDao.findAll();
		return new ResponseEntity<List<Joueur>>(joueurs, HttpStatus.OK);
	}
	
	@DeleteMapping("/joueurs/{id}")
	public ResponseEntity<Joueur> delete(@PathVariable("id") Integer id){
		Joueur tmp = joueurDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			joueurDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/joueurs")
	public ResponseEntity<Joueur> create(@Valid @RequestBody Joueur joueur) {
		if (joueur.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		joueurDao.save(joueur);
		return new ResponseEntity<Joueur>(joueur, HttpStatus.CREATED);
	}
	@PutMapping("/joueurs")
	public ResponseEntity<Joueur> update(@RequestBody Joueur joueur) {
		if (joueur.getId() == 0) {
			return create(joueur);
		}
		joueur = joueurDao.update(joueur);

		return new ResponseEntity<Joueur>(joueur, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

}
