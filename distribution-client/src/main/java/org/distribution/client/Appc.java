package org.distribution.client;

import org.distribution.Application;
import org.distribution.rest.repository.ApplicationPagedResources;
import org.distribution.rest.repository.ApplicationRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Appc {

	@Autowired
	private ApplicationRestRepository applicationRestRepository;
	
	public Appc() {}

	public void runTest() {
		ApplicationPagedResources applicationPagedResources;
		
		applicationPagedResources = applicationRestRepository.getList();
		
		
    	System.out.println(applicationPagedResources.getContent().iterator().next().getClass());

       	for (Application application : applicationPagedResources.getContent()) {
    		System.out.println("ID      = " + application.getId());
    		System.out.println("Name    = " + application.getName());
    		//System.out.println("Command = " + application.getCommand());
    	}
    	
    	System.out.println("List Size   " + applicationPagedResources.getContent().size());
    	System.out.println("links Size  " + applicationPagedResources.getLinks().size());
    	System.out.println("totalelements Size  " + applicationPagedResources.getMetadata().getTotalElements());
 		
	}
}
