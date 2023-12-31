package com.officetools.frontmattercomparisontool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrontMatterComparisonToolApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(FrontMatterComparisonToolApplication.class, args);
	}

}
