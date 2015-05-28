package org.distribution.client;

import org.distribution.rest.repository.ApplicationRestRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestRepositoryBean {

	//@Value("${baseUrl:http://localhost:8080}")
	//private String baseUrl;
	
	@Value("${securedConnexion:false}")
	private boolean securedConnexion;
	@Value("${host:localhost}")
	private String host;
	@Value("${port:8080}")
	private int port;
	
	public RestRepositoryBean() {}

	@Bean
	public ApplicationRestRepository applicationRepository() {
		return new ApplicationRestRepository(securedConnexion, host, port);
	}
	
}
