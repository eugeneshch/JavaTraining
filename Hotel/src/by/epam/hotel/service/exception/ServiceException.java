package by.epam.hotel.service.exception;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ServiceException(Exception e) {
		super(e);
	}
}
