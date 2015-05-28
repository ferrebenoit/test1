package org.distribution.rest.repository;

import java.util.ArrayList;

import org.distribution.Application;
import org.springframework.hateoas.PagedResources;

public class ApplicationPagedResources extends PagedResources<Application> {
	
	public ApplicationPagedResources() {
		super(new ArrayList<Application>(), null);
	}
}