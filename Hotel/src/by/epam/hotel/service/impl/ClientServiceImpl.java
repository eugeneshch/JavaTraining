package by.epam.hotel.service.impl;

import by.epam.hotel.dao.CommonDao;
import by.epam.hotel.dao.DAOFactory;
import by.epam.hotel.dao.exception.DaoException;
import by.epam.hotel.service.ClientService;
import by.epam.hotel.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {

	@Override
	public int authorization(String login, String password) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		CommonDao commonDao = factory.getCommonDao();
		try {
			return(commonDao.authorization(login, password));
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	} 

}
