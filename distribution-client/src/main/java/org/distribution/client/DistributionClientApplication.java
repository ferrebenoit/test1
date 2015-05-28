package org.distribution.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@ComponentScan({"org.distribution.client"})//("org.distribution.rest.repository")
//@Import(value={RestRepositoryBean.class})
@EnableAutoConfiguration(exclude={WebMvcAutoConfiguration.class})
public class DistributionClientApplication {


    public static void main(String[] args) {
    	ConfigurableApplicationContext ctx = SpringApplication.run(DistributionClientApplication.class, args);
 
    	//for (String name : ctx.getBeanDefinitionNames())
    	//	System.out.println(name);
    	Appc appc = ctx.getBean(Appc.class);
    	appc.runTest();
    	
    	//System.out.println("test");
    	/*ObjectMapper mapper = new ObjectMapper();
    	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	mapper.registerModule(new Jackson2HalModule());

    	MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    	converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
    	converter.setObjectMapper(mapper);
*/
//    	ApplicationRestRepository applicationRestRepository = new ApplicationRestRepository("http://localhost:8080");
    	
    	
//    	ApplicationPagedResources applicationPagedResources; 
    
//    	pagedResources = restTemplate.getForObject("http://localhost:8080/applications/search/findByName?name=inside", ApplicationPagedResources.class);
    	//applicationPagedResources = applicationRestRepository.getForObject("http://localhost:8080/applications", ApplicationPagedResources.class);
//    	applicationPagedResources = applicationRestRepository.getList();
//    	System.out.println(applicationPagedResources.getContent().iterator().next().getClass());
    
    	
    	
//    	for (Application application : applicationPagedResources.getContent()) {
//    		System.out.println("ID      = " + application.getId());
//    		System.out.println("Name    = " + application.getName());
//    		//System.out.println("Command = " + application.getCommand());
//    	}
//    	
//    	System.out.println("List Size   " + applicationPagedResources.getContent().size());
//    	System.out.println("links Size  " + applicationPagedResources.getLinks().size());
//    	System.out.println("totalelements Size  " + applicationPagedResources.getMetadata().getTotalElements());
//    	
    	//ArrayList<Application> applications = new ArrayList<Application>(restTemplate.getForObject("http://localhost:8080/applications/search/findByName?name=inside", PagedResources.class).getContent());
    	//Application[] applications = restTemplate.getForObject("http://localhost:8080/applications/search/findByName?name=inside", Application[].class);
    	
    	//Iterator<Application> iter = applications.iterator();
        //while (iter.hasNext()) {
        //   System.out.println(iter.next().getClass());
        //}
        
    	
    	/*for (Application application : applications) {
    		System.out.println("ID      = " + application.getId());
    		System.out.println("Name    = " + application.getName());
    		System.out.println("Command = " + application.getCommand());
    	}*/
    	
    	
    }
}
