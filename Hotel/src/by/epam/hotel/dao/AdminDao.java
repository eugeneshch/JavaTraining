package by.epam.hotel.dao;

import java.sql.Date;

import by.epam.hotel.bean.Guest;
import by.epam.hotel.dao.exception.DaoException;

public interface AdminDao {
	Guest showGuestInfo(int room_number, Date date) throws DaoException;
}
