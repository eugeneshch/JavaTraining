package by.epam.nb.dao.exception;

public class DaoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DaoException(Exception e) {
		super(e);
	}
	
}
