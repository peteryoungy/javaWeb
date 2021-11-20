package com.udacity.jwdnd.c1.review;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Locale;

@SpringBootApplication
@Configuration // note: why comment it, it still works? because the SpringBootApplication contains this function

public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}
	// todo: why my spring application don't exit with code 0?

//	@Bean
//	@Primary
//	//String message = "Hello, Spring!";
//	public String message(){
//		System.out.println("@bean message has been created");
//		return "Hello,Spring!";
//	}

//	@Bean
//	public String uppercaseMessage(MessageService messageService){
//		System.out.println("@bean uppercaseMessage has been created");
//		return messageService.uppercase();
//	}
//
//	@Bean
//	public String lowercaseMessage(MessageService messageService){
//		System.out.println("@bean lowercaseMessage has been created");
//		return messageService.lowercase();
//	}

//	@Bean
//	public String uppercaseMessage(String str){
//		System.out.println("@bean uppercaseMessage has been created");
//		return str.toUpperCase();
//	}
//
//	@Bean
//	public String lowercaseMessage(String str){
//		System.out.println("@bean lowercaseMessage has been created");
//		return str.toLowerCase();
//	}


}

