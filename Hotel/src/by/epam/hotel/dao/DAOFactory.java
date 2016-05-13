package by.epam.hotel.dao;

import by.epam.hotel.dao.impl.SQLAdminDao;
import by.epam.hotel.dao.impl.SQLCommonDao;
import by.epam.hotel.dao.impl.SQLUserDao;

public class DAOFactory {
	private static final DAOFactory factory = new DAOFactory();
	
	private final UserDao userDao = new SQLUserDao();
	private final AdminDao adminDao = new SQLAdminDao();
	private final CommonDao commonDao = new SQLCommonDao();
	
	private DAOFactory(){}

	public static DAOFactory getInstance(){
		return factory;
	}

	public UserDao getUserDao() {
		return userDao;
	}
	
	public AdminDao getAdminDao() {
		return adminDao;
	}
	
	public CommonDao getCommonDao() {
		return commonDao;
	}
}
