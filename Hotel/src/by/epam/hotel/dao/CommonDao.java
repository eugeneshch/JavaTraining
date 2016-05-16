package by.epam.hotel.dao;

import by.epam.hotel.dao.exception.DaoException;

public interface CommonDao {
	int authorization(String login, String password) throws DaoException;
}
