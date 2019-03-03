package com.school.schoolweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages= {"com.school.schoolweb.dao"})
@EnableScheduling
public class SchoolwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolwebApplication.class, args);
	}

}
