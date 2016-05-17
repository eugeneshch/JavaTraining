package by.epam.hotel.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import by.epam.hotel.dao.UserDao;
import by.epam.hotel.dao.exception.DaoException;
import by.epam.hotel.util.connectionpool.ConnectionPool;
import by.epam.hotel.util.connectionpool.ConnectionPoolException;

public class SQLUserDao implements UserDao {
	private ConnectionPool connectionPool = ConnectionPool.getInstance();
	
	@Override
	public boolean checkRoomFreeByDate(int room_number, Date date_from, Date date_to) throws DaoException {
		Connection con;
		try {
			con = connectionPool.takeConnection();
			Statement statement = con.createStatement();
			String query = "SELECT * FROM `bookings` WHERE " 
			+ "`date_from` <= '" + date_to + "' AND `date_to` >= '" + date_from 			
			+ "' AND `room_id` = "
			+ "(SELECT `r_id` FROM `rooms` WHERE `r_number` = '" + room_number + "')";
			ResultSet resultSet = statement.executeQuery(query);
			boolean isAvailable = !resultSet.next();
			connectionPool.closeConnection(con, statement, resultSet);
			return(isAvailable);
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Integer> findAvailableRoomsByDate(Date date_from, Date date_to) throws DaoException {
		Connection con;
		try {
			con = connectionPool.takeConnection();
			Statement statement = con.createStatement();
			String query = "SELECT `r_number` FROM `rooms` WHERE `r_id` NOT IN (SELECT `room_id` FROM `bookings` WHERE " 
			+ "`date_from` <= '" + date_to + "' AND `date_to` >= '" + date_from + "')";
			ResultSet resultSet = statement.executeQuery(query);
			List<Integer> room_nums = new ArrayList<Integer>();
			while (resultSet.next()) {
				room_nums.add(resultSet.getInt("r_number"));
			}
			connectionPool.closeConnection(con, statement, resultSet);
			return(room_nums);
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Date[]> showRoomBookings(int room_number) throws DaoException {
		Connection con;
		try {
			con = connectionPool.takeConnection();
			Statement statement = con.createStatement();
			String query = "SELECT `date_from`, `date_to` FROM `bookings` WHERE `room_id` = "
			+ "(SELECT `r_id` FROM `rooms` WHERE `r_number` = '" + room_number + "')";
			ResultSet resultSet = statement.executeQuery(query);
			List<Date[]> date_bookings = new ArrayList<Date[]>();
			while (resultSet.next()) {
				Date[] booking_date = {resultSet.getDate("date_from"), resultSet.getDate("date_to")};
				date_bookings.add(booking_date);
			}
			connectionPool.closeConnection(con, statement, resultSet);
			return(date_bookings);
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void bookRoom(String user_name, int room_number, Date date_from, Date date_to) throws DaoException {
		Connection con;
		try {
			con = connectionPool.takeConnection();
			Statement statement = con.createStatement();
			String update = "INSERT INTO `bookings` (`date_from`, `date_to`, `room_id`, `guest_id`) VALUES ('"
			+ date_from + "', '" + date_to + "', (SELECT `r_id` FROM `rooms` WHERE `r_number` = '" + room_number
			+ "'), (SELECT `u_id` FROM `users` WHERE `u_login` = '" + user_name + "'))";
			System.out.println(update);
			statement.executeUpdate(update);
			connectionPool.closeConnection(con, statement);
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public void unBookRoom(String user_name, int room_number, Date date_from) throws DaoException {
		Connection con;
		try {
			con = connectionPool.takeConnection();
			Statement statement = con.createStatement();
			String update = "DELETE FROM `bookings` WHERE `guest_id` = (SELECT `u_id` FROM `users` WHERE `u_login` = '" + user_name
			+ "') AND `room_id` = (SELECT `r_id` FROM `rooms` WHERE `r_number` = '" + room_number + "') AND `date_from` = '" + date_from + "'";
			statement.executeUpdate(update);
			connectionPool.closeConnection(con, statement);
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		}	
	}
}
