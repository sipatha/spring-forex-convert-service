package cib.eureka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ForexConvertServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForexConvertServiceApplication.class, args);
	}

}
