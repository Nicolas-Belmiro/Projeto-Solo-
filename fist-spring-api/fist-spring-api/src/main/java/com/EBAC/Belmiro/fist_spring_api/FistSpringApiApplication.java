package com.EBAC.Belmiro.fist_spring_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//  Essas 3 anotaçoes ja estao escritas nessa acima por comfig padrao

//  @Configuration
//  @EnableAutoConfiguration
//  @ComponentScan
public class FistSpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FistSpringApiApplication.class, args);
	}

}
