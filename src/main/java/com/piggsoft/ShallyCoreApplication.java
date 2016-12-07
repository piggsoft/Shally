package com.piggsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ShallyCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShallyCoreApplication.class, args);
	}
}
