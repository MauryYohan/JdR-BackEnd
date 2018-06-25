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
import com.jdr.dao.ImageDao;
import com.jdr.entity.Image;
import com.jdr.entity.Views;


@RestController
@CrossOrigin
public class ImageController {
	
	@Autowired	
	ImageDao imageDao;
	
	@GetMapping("/images/{id}")
	public ResponseEntity<Image> findOne(@PathVariable("id") Integer id){
		
		Image b = imageDao.findByPrimaryKey(id);
		
		if(b == null) {
			return new ResponseEntity<Image>(b, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Image>(b, HttpStatus.OK);
		}
	}
	
	@GetMapping("/images")
	public ResponseEntity<List<Image>> findAll() {
		List<Image> images = imageDao.findAll();
		return new ResponseEntity<List<Image>>(images, HttpStatus.OK);
	}
	
	@DeleteMapping("/images/{id}")
	public ResponseEntity<Image> delete(@PathVariable("id") Integer id){
		Image tmp = imageDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			imageDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/images")
	public ResponseEntity<Image> create(@Valid @RequestBody Image image) {
		if (image.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		imageDao.save(image);
		return new ResponseEntity<Image>(image, HttpStatus.CREATED);
	}
	@PutMapping("/images")
	public ResponseEntity<Image> update(@RequestBody Image image) {
		if (image.getId() == 0) {
			return create(image);
		}
		image = imageDao.update(image);

		return new ResponseEntity<Image>(image, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

}
