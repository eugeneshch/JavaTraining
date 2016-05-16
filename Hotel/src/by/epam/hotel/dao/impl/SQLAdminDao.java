package by.epam.hotel.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import by.epam.hotel.dao.AdminDao;
import by.epam.hotel.dao.exception.DaoException;
import by.epam.hotel.util.connectionpool.ConnectionPool;
import by.epam.hotel.util.connectionpool.ConnectionPoolException;

public class SQLAdminDao implements AdminDao {
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public String showGuestInfo(int room_number, Date date) throws DaoException {
		Connection con;
		try {
			con = connectionPool.takeConnection();
			Statement statement = con.createStatement();
			String query = "SELECT * FROM `guests` WHERE `g_id`= "
			+ "(SELECT `guest_id` FROM `bookings` WHERE `date_from` <= '" + date 
			+ "' AND `date_to` >= '" + date + "' AND `room_id` = "
			+ "(SELECT `r_id` FROM `rooms` WHERE `r_number` = '" + room_number + "'))";
			ResultSet resultSet = statement.executeQuery(query);
			StringBuilder guest = new StringBuilder();
			if (resultSet.next()) {
				guest.append(resultSet.getString("g_fname") + " ");
				guest.append(resultSet.getString("g_lname") + " ");
				guest.append(resultSet.getString("g_phone"));
			}
			connectionPool.closeConnection(con, statement, resultSet);
			return guest.toString();
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		}
	}

}
