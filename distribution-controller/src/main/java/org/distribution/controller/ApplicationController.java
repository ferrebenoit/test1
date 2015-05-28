/**
 * 
 */
package org.distribution.controller;

import org.distribution.Application;
import org.distribution.jpa.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ben
 *
 */

@Controller
public class ApplicationController {

	@Autowired
	private ApplicationRepository applicationRepository;
	
	@ModelAttribute("allApplications")
	public Iterable<Application> populateApplications() {
		return applicationRepository.findAll();
	}
	
	@RequestMapping(value="listapp")
	public String showApplications() {
		
		return "applications";
	}
}
