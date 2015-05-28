/**
 * 
 */
package org.distribution.jpa.repository;

import org.distribution.Command;
import org.distribution.repository.jdbc.RepositoryJDBC;

/**
 * @author ben
 *
 */
public interface CommandRepository extends RepositoryJDBC<Command, Long> {

	//List<Command> findByType(@Param("type") String Name);
}
