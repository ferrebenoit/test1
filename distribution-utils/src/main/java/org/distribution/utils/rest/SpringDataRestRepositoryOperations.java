/**
 * 
 */
package org.distribution.utils.rest;

/**
 * @author ben
 *
 */
public class SpringDataRestRepositoryOperations<T> extends SpringDataRestRepository implements RestRepositoryOperations<T> {

	final Class<T> typeParameterClass;
	
	private String baseUrl;
	//private boolean secure;
	//private String host;
	//private int port;
	
	private String endPoint;
	
	private final String httpsBaseURLBuilder = "https://%s:%s";
	private final String httpBaseURLBuilder  = "https://%s:%s";
	
	private final String listUrlBuilder = "%s/%ss";
	private final String getForIdUrlBuilder = "%s/%ss/%d";

	/**
	 * 
	 */
	public SpringDataRestRepositoryOperations(Class<T> typeParameterClass, boolean secure, String host, int port, String endPoint) {
		super();
		
		this.typeParameterClass = typeParameterClass;
		
		if (secure)
			this.baseUrl = String.format(httpsBaseURLBuilder, host, port);
		else
			this.baseUrl = String.format(httpBaseURLBuilder, host, port);
			
		this.endPoint = endPoint;
		
	}
	
	protected String getListUrl() {
		return String.format(listUrlBuilder, baseUrl, endPoint);
	}
	
	protected String getForIdUrl(int id) {
		return String.format(getForIdUrlBuilder, baseUrl, endPoint, id);
	}

	@Override
	public T getList() {
		return restTemplate.getForObject(getListUrl(), typeParameterClass);
	}

	@Override
	public T getForName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getForName(String name, int size, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getForID(Integer id) {
		return restTemplate.getForObject(getListUrl(), typeParameterClass);
	}
}
