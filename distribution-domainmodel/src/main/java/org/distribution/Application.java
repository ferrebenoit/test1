package org.distribution;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ben
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Application {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name = "APPLICATION_ID")
	private long id;
	
	private String name;
	private String version;
	
	@OneToMany(mappedBy = "application")
	private Set<Installation> installations;
	
	@OneToMany(mappedBy = "application")
	private Set<Command> installCommands;

	@ManyToOne
	private Application parent;
	
	@OneToMany(mappedBy="parent")
	private Set<Application> applicationDependencies;
	
	//private Set<Shortcut> Shortcuts;
	//private Set<Registry> regChanges;
	//private Set<FileCopy> fileCopies;
	//private Boolean isDelprofNeeded;
	//private HashMap<String, Parameter> parameters;

	//private URI SourceFiles;
	
	
	public Application() {
		super();
	}

	public Set<Application> getApplicationDependencies() {
		return applicationDependencies;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the installations
	 */
	public Set<Installation> getInstallations() {
		return installations;
	}

	/**
	 * @return the installCommands
	 */
	public Set<Command> getInstallCommands() {
		return installCommands;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public Application getParent() {
		return parent;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

}
