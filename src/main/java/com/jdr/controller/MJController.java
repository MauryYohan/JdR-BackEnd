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
import com.jdr.dao.MJDao;
import com.jdr.entity.MJ;
import com.jdr.entity.Views;


@RestController
@CrossOrigin
public class MJController {
	
	@Autowired	
	MJDao mjDao;
	
	@GetMapping("/mjs/{id}")
	public ResponseEntity<MJ> findOne(@PathVariable("id") Integer id){
		
		MJ b = mjDao.findByPrimaryKey(id);
		
		if(b == null) {
			return new ResponseEntity<MJ>(b, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<MJ>(b, HttpStatus.OK);
		}
	}
	
	@GetMapping("/mjs")
	public ResponseEntity<List<MJ>> findAll() {
		List<MJ> mjs = mjDao.findAll();
		return new ResponseEntity<List<MJ>>(mjs, HttpStatus.OK);
	}
	
	@DeleteMapping("/mjs/{id}")
	public ResponseEntity<MJ> delete(@PathVariable("id") Integer id){
		MJ tmp = mjDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			mjDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/mjs")
	public ResponseEntity<MJ> create(@Valid @RequestBody MJ mj) {
		if (mj.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		mjDao.save(mj);
		return new ResponseEntity<MJ>(mj, HttpStatus.CREATED);
	}
	@PutMapping("/mjs")
	public ResponseEntity<MJ> update(@RequestBody MJ mj) {
		if (mj.getId() == 0) {
			return create(mj);
		}
		mj = mjDao.update(mj);

		return new ResponseEntity<MJ>(mj, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

}
