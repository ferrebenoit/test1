/**
 * 
 */
package org.distribution.repository.jdbc;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author ben
 *
 */
@NoRepositoryBean
public interface RepositoryJDBC<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {}
