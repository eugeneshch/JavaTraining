package by.epam.hotel.service.impl;

import java.sql.Date;
import java.util.List;

import by.epam.hotel.dao.AdminDao;
import by.epam.hotel.dao.DAOFactory;
import by.epam.hotel.dao.UserDao;
import by.epam.hotel.dao.exception.DaoException;
import by.epam.hotel.service.HotelService;
import by.epam.hotel.service.exception.ServiceException;

public class HotelServiceImpl implements HotelService {

	@Override
	public boolean checkRoomFreeByDate(int room_number, Date date_from, Date date_to) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		UserDao userDao = factory.getUserDao();
		try {
			return(userDao.checkRoomFreeByDate(room_number, date_from, date_to));
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Integer> findAvailableRoomsByDate(Date date_from, Date date_to) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		UserDao userDao = factory.getUserDao();
		try {
			return(userDao.findAvailableRoomsByDate(date_from, date_to));
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Date[]> showRoomBookings(int room_number) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		UserDao userDao = factory.getUserDao();
		try {
			return(userDao.showRoomBookings(room_number));
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void bookRoom(String user_name, int room_number, Date date_from, Date date_to) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		UserDao userDao = factory.getUserDao();
		try {
			userDao.bookRoom(user_name, room_number, date_from, date_to);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public String showGuestInfo(int room_number, Date date) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		AdminDao adminDao = factory.getAdminDao();
		try {
			return(adminDao.showGuestInfo(room_number, date));
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
