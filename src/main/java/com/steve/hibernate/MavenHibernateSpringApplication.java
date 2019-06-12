package com.steve.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"com.steve.hibernate"}) 
@EnableJpaAuditing // created_at update_at
public class MavenHibernateSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenHibernateSpringApplication.class, args);
	}

}
