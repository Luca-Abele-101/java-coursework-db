package com.example.CourseWork4.main;

import com.example.CourseWork4.main.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CourseWork4Application
{
	private static final Logger log = LoggerFactory.getLogger(CourseWork4Application.class);

	public static void main(String[] args)
	{
		SpringApplication.run(CourseWork4Application.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
