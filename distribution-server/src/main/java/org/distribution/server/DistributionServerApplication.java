package org.distribution.server;


import org.distribution.jpa.repository.IDConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("org.distribution")
@EnableJpaRepositories(basePackages = {"org.distribution.common.repository"})
@SpringBootApplication
//@Import(RepositoryRestMvcConfiguration.class)
@Import(IDConfiguration.class)
@EnableAutoConfiguration
public class DistributionServerApplication {
	
    public static void main(String[] args) {
    	SpringApplication.run(DistributionServerApplication.class, args);
    }
}
