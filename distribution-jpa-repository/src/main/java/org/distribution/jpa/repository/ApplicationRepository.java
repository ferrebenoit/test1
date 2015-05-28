/**
 * 
 */
package org.distribution.jpa.repository;

import java.util.List;

import org.distribution.Application;
import org.distribution.repository.jdbc.RepositoryJDBC;
import org.springframework.data.repository.query.Param;

/**
 * @author ben
 *
 */
public interface ApplicationRepository extends RepositoryJDBC<Application, Long> {

	List<Application> findByName(@Param("name") String Name);
}
