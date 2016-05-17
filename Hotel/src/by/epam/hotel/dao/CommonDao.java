package by.epam.hotel.dao;

import by.epam.hotel.bean.Guest;
import by.epam.hotel.dao.exception.DaoException;

public interface CommonDao {
	int authorize(String login, String password) throws DaoException;
	void register(String login, String password, String email, Guest guest) throws DaoException;
}
