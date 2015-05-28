/**
 * 
 */
package org.distribution.utils.rest;

import java.util.Collections;

import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ben
 *
 */
public class SpringDataRestRepository {

	protected RestTemplate restTemplate;
	/**
	 * 
	 */
	public SpringDataRestRepository() {
		ObjectMapper mapper = new ObjectMapper();
    	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	mapper.registerModule(new Jackson2HalModule());

    	MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    	converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
    	converter.setObjectMapper(mapper);
    	
    	restTemplate = new RestTemplate();
    	restTemplate.setMessageConverters(Collections.<HttpMessageConverter<?>> singletonList(converter));
	}

	
	
}
