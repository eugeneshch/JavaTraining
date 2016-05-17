package by.epam.hotel.service;

import java.sql.Date;
import java.util.List;

import by.epam.hotel.bean.Guest;
import by.epam.hotel.service.exception.ServiceException;

public interface HotelService {
	boolean checkRoomFreeByDate(int room_number, Date date_from, Date date_to) throws ServiceException;
	List<Integer> findAvailableRoomsByDate(Date date_from, Date date_to) throws ServiceException;
	List<Date[]> showRoomBookings(int room_number) throws ServiceException;
	void bookRoom(String user_name, int room_number, Date date_from, Date date_to) throws ServiceException;
	void unBookRoom(String user_name, int room_number, Date date_from) throws ServiceException;
	Guest showGuestInfo(int room_number, Date date) throws ServiceException;
}
