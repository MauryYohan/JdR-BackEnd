package com.jdr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jdr.dao.UtilisateurDao;
import com.jdr.entity.Utilisateur;

@SpringBootApplication
public class SpringBootStartApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartApplication.class, args);		
	}

}