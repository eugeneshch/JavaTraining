package by.epam.hotel.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.epam.hotel.dao.CommonDao;
import by.epam.hotel.dao.exception.DaoException;
import by.epam.hotel.util.connectionpool.ConnectionPool;
import by.epam.hotel.util.connectionpool.ConnectionPoolException;

public class SQLCommonDao implements CommonDao {
	private ConnectionPool connectionPool = ConnectionPool.getInstance();
	
	@Override
	public int authorization(String login, String password) throws DaoException {
		Connection con;
		try {
			con = connectionPool.takeConnection();
			Statement statement = con.createStatement();
			String query = "SELECT `u_role` FROM `users` WHERE `u_login`= '" + login + 
			"' AND `u_password`= '" + password + "'";
			ResultSet resultSet = statement.executeQuery(query);
			int role = 0; // unauthorized
			if (resultSet.next()) {
				role = resultSet.getInt("u_role");
			}
			connectionPool.closeConnection(con, statement, resultSet);
			return role;
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		}
	}
}
