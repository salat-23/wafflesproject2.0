package com.salat23.spring.security.waffles;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
