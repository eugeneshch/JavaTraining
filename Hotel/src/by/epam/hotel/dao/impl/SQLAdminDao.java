package by.epam.hotel.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.epam.hotel.bean.Guest;
import by.epam.hotel.dao.AdminDao;
import by.epam.hotel.dao.exception.DaoException;
import by.epam.hotel.util.connectionpool.ConnectionPool;
import by.epam.hotel.util.connectionpool.ConnectionPoolException;

public class SQLAdminDao implements AdminDao {
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public Guest showGuestInfo(int room_number, Date date) throws DaoException {
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			con = connectionPool.takeConnection();
			statement = con.createStatement();
			String query = "SELECT * FROM `guests` WHERE `g_id`= "
			+ "(SELECT `guest_id` FROM `bookings` WHERE `date_from` <= '" + date 
			+ "' AND `date_to` >= '" + date + "' AND `room_id` = "
			+ "(SELECT `r_id` FROM `rooms` WHERE `r_number` = '" + room_number + "'))";
			resultSet = statement.executeQuery(query);
			Guest guest = new Guest();
			if (resultSet.next()) {
				guest.setFName(resultSet.getString("g_fname"));
				guest.setLName(resultSet.getString("g_lname"));
				guest.setPhone(resultSet.getString("g_phone"));
			}
			return guest;
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				connectionPool.closeConnection(con, statement, resultSet);
			} catch (ConnectionPoolException e) {
				throw new DaoException(e);
			}
		}
	}

}
