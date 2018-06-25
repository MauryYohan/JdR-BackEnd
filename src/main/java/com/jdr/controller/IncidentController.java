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
import com.jdr.dao.IncidentDao;
import com.jdr.entity.Incident;
import com.jdr.entity.Views;


@RestController
@CrossOrigin
public class IncidentController {
	
	@Autowired	
	IncidentDao incidentDao;
	
	@GetMapping("/incidents/{id}")
	public ResponseEntity<Incident> findOne(@PathVariable("id") Integer id){
		
		Incident b = incidentDao.findByPrimaryKey(id);
		System.out.println("caca");
		if(b == null) {
			return new ResponseEntity<Incident>(b, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Incident>(b, HttpStatus.OK);
		}
	}
	
	@GetMapping("/incidents")
	public ResponseEntity<List<Incident>> findAll() {
		List<Incident> incidents = incidentDao.findAll();
		return new ResponseEntity<List<Incident>>(incidents, HttpStatus.OK);
	}
	
	@DeleteMapping("/incidents/{id}")
	public ResponseEntity<Incident> delete(@PathVariable("id") Integer id){
		Incident tmp = incidentDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			incidentDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/incidents")
	public ResponseEntity<Incident> create(@Valid @RequestBody Incident incident) {
		if (incident.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		incidentDao.save(incident);
		return new ResponseEntity<Incident>(incident, HttpStatus.CREATED);
	}
	@PutMapping("/incidents")
	public ResponseEntity<Incident> update(@RequestBody Incident incident) {
		if (incident.getId() == 0) {
			return create(incident);
		}
		incident = incidentDao.update(incident);

		return new ResponseEntity<Incident>(incident, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

}
