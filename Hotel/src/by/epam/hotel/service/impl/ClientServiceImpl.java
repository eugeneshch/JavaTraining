package by.epam.hotel.service.impl;

import by.epam.hotel.bean.Guest;
import by.epam.hotel.dao.CommonDao;
import by.epam.hotel.dao.DAOFactory;
import by.epam.hotel.dao.exception.DaoException;
import by.epam.hotel.service.ClientService;
import by.epam.hotel.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {

	@Override
	public int authorize(String login, String password) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		CommonDao commonDao = factory.getCommonDao();
		try {
			return(commonDao.authorize(login, password));
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void register(String login, String password, String email, Guest guest) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		CommonDao commonDao = factory.getCommonDao();
		try {
			commonDao.register(login, password, email, guest);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	} 

}
