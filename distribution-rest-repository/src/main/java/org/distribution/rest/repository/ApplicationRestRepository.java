/**
 * 
 */
package org.distribution.rest.repository;

import org.distribution.utils.rest.SpringDataRestRepositoryOperations;

/**
 * @author ben
 *
 */
public class ApplicationRestRepository extends SpringDataRestRepositoryOperations<ApplicationPagedResources> {

	/**
	 * @param baseUrl
	 */
	public ApplicationRestRepository(boolean secure, String host, int port) {
		super(ApplicationPagedResources.class, secure, host, port, "application");
	}
}
