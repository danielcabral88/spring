package com.livraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
//import org.springframework.boot.orm.jpa.EntityScan; 
import org.springframework.context.annotation.ComponentScan; 
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; 


@SpringBootApplication 
//@EntityScan(basePackages = { "com.livraria.entity" }) 
@EnableJpaRepositories(basePackages = { "com.livraria.repository" }) 
@ComponentScan(basePackages = {"com.livraria.controller"}) 

public class LivrariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}
}
