package com.app.studenthub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.app.studenthub.model")
public class StudenthubApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudenthubApplication.class, args);
	}

}
