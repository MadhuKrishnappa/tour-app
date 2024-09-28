package com.tour.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan("com.tour.app")
//@ImportResource({ "classpath:/application_context.xml"})
public class TourAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourAppApplication.class, args);
	}

}
