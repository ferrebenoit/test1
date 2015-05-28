package org.distribution.jpa.repository;

import org.distribution.Computer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class IDConfiguration extends RepositoryRestMvcConfiguration {

	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Computer.class);
		config.setReturnBodyOnCreate(true);
		config.setReturnBodyOnUpdate(true);
	}
}
