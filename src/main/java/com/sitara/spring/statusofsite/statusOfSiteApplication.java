package com.sitara.spring.statusofsite;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class statusOfSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(statusOfSiteApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context){

		return args ->{
			System.out.println("Let's learn spring boot !");
			String[] beanNames = context.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for(String str:beanNames){
				System.out.println(str);
			}

		};

	}

}
