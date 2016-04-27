package by.epam.nb.dao;

import by.epam.nb.dao.impl.FileUserDao;

public class DAOFactory {
	private static final DAOFactory factory = new DAOFactory();
	
	private final UserDao userDao = new FileUserDao();
	
	private DAOFactory(){}

	public static DAOFactory getInstance(){
		return factory;
	}

	public UserDao getUserDao() {
		return userDao;
	}
}
