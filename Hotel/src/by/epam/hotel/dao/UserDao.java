package by.epam.hotel.dao;

import java.sql.Date;
import java.util.List;

import by.epam.hotel.dao.exception.DaoException;

public interface UserDao {
	boolean checkRoomFreeByDate(int room_number, Date date_from, Date date_to) throws DaoException;
	List<Integer> findAvailableRoomsByDate(Date date_from, Date date_to) throws DaoException;
	List<Date[]> showRoomBookings(int room_number) throws DaoException;
	void bookRoom(String user_name, int room_number, Date date_from, Date date_to) throws DaoException;
	void unBookRoom(String user_name, int room_number, Date date_from) throws DaoException;
}
