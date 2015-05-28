package org.distribution.utils.rest;

public interface RestRepositoryOperations<T> {

	public T getList();
	public T getForName(String name);
	public T getForName(String name, int size, int pageNumber);
	public T getForID(Integer id);
}
