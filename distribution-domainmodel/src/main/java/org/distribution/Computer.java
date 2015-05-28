package org.distribution;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ben
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Computer {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name = "COMPUTER_ID")
	private long id;
	
	private String name;
	private String macAddress;
	
	@OneToMany(mappedBy = "computer")
	private Set<Installation> installations;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the macAddress
	 */
	public String getMacAddress() {
		return macAddress;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	
	
}
