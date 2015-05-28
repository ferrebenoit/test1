package org.distribution;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Command {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Application application;
	
	private CommandType type;
	private Integer index;
	
	private String executablePath;
	private String Args;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return the application
	 */
	public Application getApplication() {
		return application;
	}
	/**
	 * @return the type
	 */
	public CommandType getType() {
		return type;
	}
	/**
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}
	/**
	 * @return the executablePath
	 */
	public String getExecutablePath() {
		return executablePath;
	}
	/**
	 * @return the args
	 */
	public String getArgs() {
		return Args;
	}
	
	
}
