package by.epam.hotel.service;

import by.epam.hotel.service.exception.ServiceException;

public interface ClientService {
	int authorization(String login, String password) throws ServiceException;
}
