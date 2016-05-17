package by.epam.hotel.service;

import by.epam.hotel.bean.Guest;
import by.epam.hotel.service.exception.ServiceException;

public interface ClientService {
	int authorize(String login, String password) throws ServiceException;
	void register(String login, String password, String email, Guest guest) throws ServiceException;
}
