/**
 * 
 */
package org.distribution;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ben
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Installation {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "COMPUTER_ID")
	private Computer computer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "APPLICATION_ID")
	private Application application;
	
	private InstallState state;
	
	private Date plannedDate;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the computer
	 */
	public Computer getComputer() {
		return computer;
	}

	/**
	 * @return the application
	 */
	public Application getApplication() {
		return application;
	}

	/**
	 * @return the state
	 */
	public InstallState getState() {
		return state;
	}

	public Date getPlannedDate() {
		return plannedDate;
	}

	public void setPlannedDate(Date plannedDate) {
		this.plannedDate = plannedDate;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public void setState(InstallState state) {
		this.state = state;
	}
}
