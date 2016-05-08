package by.epam.nb.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.epam.nb.bean.Note;
import by.epam.nb.bean.NoteBook;
import by.epam.nb.dao.UserDao;
import by.epam.nb.dao.exception.DaoException;
import by.epam.nb.util.connectionpool.ConnectionPool;
import by.epam.nb.util.connectionpool.ConnectionPoolException;

public class SQLUserDao implements UserDao {
	private ConnectionPool connectionPool = null;
	
	private void initPool() throws DaoException {
		if (connectionPool == null) {
			connectionPool = ConnectionPool.getInstance();
			try {
				connectionPool.initPoolData();
			} catch (ConnectionPoolException e) {
				throw new DaoException(e);
			}
		}	
	}
	
	@Override
	public NoteBook loadNoteBook(String name) throws DaoException {
		initPool();
		try {
			Connection con = connectionPool.takeConnection();
			Statement statement = con.createStatement();
			String query = "SELECT `time` FROM `notebook` WHERE `name`= '" + name + "'";
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			NoteBook noteBook = new NoteBook(resultSet.getLong("time"));
			resultSet.close();
			query = "SELECT `text`, `time` FROM `note` WHERE `notebookname`= '" + name + "'";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				noteBook.addNote(new Note(resultSet.getString("text"), resultSet.getLong("time")));
			}
			connectionPool.closeConnection(con, statement, resultSet);
			return noteBook;
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void saveNoteBook(String name, NoteBook noteBook) throws DaoException {
		initPool();
		try {
			Connection con = connectionPool.takeConnection();
			Statement statement = con.createStatement();
			String update = "INSERT INTO `notebook` (`name`, `time`) VALUES ('" + name +"', '" + noteBook.getCreationTime() +"')";
			//String update = "INSERT INTO `notebook`.`notebook` (`name`, `time`) VALUES ('test1', '10001')";
			statement.executeUpdate(update);
			for (Note note : noteBook.getNote()) {
				statement.addBatch("INSERT INTO `note` (`text`, `time`, `notebookname`) VALUES ('" + note.getText() +"', '" + note.getTime() +"', '" + name +"')");
			}
			statement.executeBatch();
			connectionPool.closeConnection(con, statement);
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	protected void finalize() throws Throwable {
		connectionPool.dispose();
		super.finalize();
	}
	
	

}
