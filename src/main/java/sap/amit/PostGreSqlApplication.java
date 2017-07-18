package sap.amit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration 
//@ComponentScan("sap.amit.controller") 
@SpringBootApplication
public class PostGreSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostGreSqlApplication.class, args);
		
	}
	
}
