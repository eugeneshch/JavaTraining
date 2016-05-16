package by.epam.hotel.dao;

import java.sql.Date;

import by.epam.hotel.dao.exception.DaoException;

public interface AdminDao {
	String showGuestInfo(int room_number, Date date) throws DaoException;
}
