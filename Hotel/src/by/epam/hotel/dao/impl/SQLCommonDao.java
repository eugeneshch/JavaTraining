package by.epam.hotel.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.epam.hotel.bean.Guest;
import by.epam.hotel.dao.CommonDao;
import by.epam.hotel.dao.exception.DaoException;
import by.epam.hotel.util.connectionpool.ConnectionPool;
import by.epam.hotel.util.connectionpool.ConnectionPoolException;

public class SQLCommonDao implements CommonDao {
	private ConnectionPool connectionPool = ConnectionPool.getInstance();
	
	@Override
	public int authorize(String login, String password) throws DaoException {
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			con = connectionPool.takeConnection();
			statement = con.createStatement();
			String query = "SELECT `u_role` FROM `users` WHERE `u_login`= '" + login + 
			"' AND `u_password`= '" + password + "'";
			resultSet = statement.executeQuery(query);
			int role = -1; // unauthorized
			if (resultSet.next()) {
				role = resultSet.getInt("u_role");
			}
			return role;
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

	@Override
	public void register(String login, String password, String email, Guest guest) throws DaoException {
		Connection con = null;
		Statement statement = null;
		try {
			con = connectionPool.takeConnection();
			statement = con.createStatement();
			String update = "INSERT INTO `users` (`u_login`, `u_password`, `u_email`, `u_role`) VALUES ('"
			+ login + "', '" + password + "', '" + email + "', '0')";
			statement.executeUpdate(update);
			update = "INSERT INTO `guests` (`g_id`, `g_fname`, `g_lname`, `g_phone`) VALUES " 
			+ "((SELECT `u_id` FROM `users` WHERE `u_login`= '" + login + "'), '"
			+ guest.getFName() + "', '" + guest.getLName() + "', '" + guest.getPhone() + "')";
			statement.executeUpdate(update);
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			try {
				connectionPool.closeConnection(con, statement);
			} catch (ConnectionPoolException e) {
				throw new DaoException(e);
			}
		}	
	}
}
