package by.epam.hotel.service.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.hotel.bean.Guest;
import by.epam.hotel.service.ClientService;
import by.epam.hotel.service.HotelService;
import by.epam.hotel.service.ServiceFactory;
import by.epam.hotel.service.exception.ServiceException;
import by.epam.hotel.util.connectionpool.ConnectionPool;
import by.epam.hotel.util.connectionpool.ConnectionPoolException;

public class ServiceImplTest {
	ServiceFactory factory = ServiceFactory.getInstance();
	ClientService clientService = factory.getClientService();
	HotelService hotelService = factory.getHotelService();
	ConnectionPool connectionPool = ConnectionPool.getInstance();
	Connection con;
	Statement statement;
	
	@BeforeClass
	public void beforeClass() throws ConnectionPoolException, SQLException {
		connectionPool.initPoolData();
		con = connectionPool.takeConnection();
		statement = con.createStatement();
	}

	@AfterClass
	public void afterClass() throws ConnectionPoolException {
		connectionPool.closeConnection(con, statement);
		connectionPool.dispose();
	}
	
	@DataProvider
	public Object[][] users() {
	  return new Object[][] {
	    new Object[] { "user01", "password01", "email01@email.email", new Guest("Fname1", "Lname1", "111-11-11") },
	  };
	}
	
	@Test(dataProvider = "users")
	public void registerTest(String login, String password, String email, Guest guest) throws ServiceException, ConnectionPoolException, SQLException {
		String query = "SELECT * FROM `users` WHERE `u_login`= '" + login + "'";
		ResultSet resultSet = statement.executeQuery(query);
		boolean result = resultSet.next();
		resultSet.close();
		Assert.assertFalse(result);
		clientService.register(login, password, email, guest);
		query = "SELECT * FROM `users` WHERE `u_login`= '" + login + "'";
		resultSet = statement.executeQuery(query);
		result = resultSet.next();
		resultSet.close();
		Assert.assertTrue(result);
	}
	
	@DataProvider
	public Object[][] logins() {
	  return new Object[][] {
	    new Object[] { "user01", "password01", 0 },
	    new Object[] { "user02", "password01", -1 },
	    new Object[] { "user01", "password02", -1 },
	    new Object[] { "user02", "password02", -1 },
	  };
	}	
	
	@Test(dataProvider = "logins")
	public void authorizeTest(String login, String password, int role) throws ServiceException {
		Assert.assertEquals(clientService.authorize(login, password), role);
	}
	
	@DataProvider
	public Object[][] is_room_free() {
	  return new Object[][] {
	    new Object[] { 101, new Date(1000), new Date(1000), false },
	    new Object[] { 102, new Date(1000), new Date(1000), true },
	    new Object[] { 103, new Date(1000), new Date(1000), true },
	    new Object[] { 104, new Date(1000), new Date(1000), true },
	    new Object[] { 105, new Date(1000), new Date(1000), true },
	  };
	}
	
	@Test(dataProvider = "is_room_free")
	public void checkRoomFreeByDate(int room_number, Date date_from, Date date_to, boolean result) throws ServiceException {
		Assert.assertEquals(hotelService.checkRoomFreeByDate(room_number, date_from, date_to), result);
	}
	
	@DataProvider
	public Object[][] rooms_free() {
		return new Object[][] {
	    new Object[] { new Date(1000), new Date(1000), Arrays.asList(102, 103, 104, 105)},
	  };
	}
	
	@Test(dataProvider = "rooms_free")
	public void findAvailableRoomsByDate(Date date_from, Date date_to, List<Integer> rooms) throws ServiceException {
		Assert.assertEquals(hotelService.findAvailableRoomsByDate(date_from, date_to), rooms);
	}
	
	@DataProvider
	public Object[][] booking_dates() {
		return new Object[][] {
	    new Object[] { 102, Arrays.asList()},
	    new Object[] { 103, Arrays.asList()},
	    new Object[] { 104, Arrays.asList()},
	    new Object[] { 105, Arrays.asList()},
	  };
	}
	
	@Test(dataProvider = "booking_dates")
	public void showRoomBookings(int room_number, List<Date[]> dates) throws ServiceException {
		Assert.assertEquals(hotelService.showRoomBookings(room_number), dates);
	}
	
	@DataProvider
	public Object[][] booking_room() {
		return new Object[][] {
	    new Object[] { "user01", 101, new Date(1000), new Date(1000)},
	  };
	}
	
	@Test(dataProvider = "booking_room")
	public void bookRoom(String user_name, int room_number, Date date_from, Date date_to) throws ServiceException, SQLException {
		String query = "SELECT * FROM `bookings` WHERE `guest_id` = (SELECT `u_id` FROM `users` WHERE `u_login` = '" + user_name 
					+ "') AND `room_id` = (SELECT `r_id` FROM `rooms` WHERE `r_number` = '" + room_number 
					+ "') AND `date_from` = '" + date_from + "' AND `date_to` = '" + date_to + "'";
		ResultSet resultSet = statement.executeQuery(query);
		boolean result = resultSet.next();
		resultSet.close();
		Assert.assertFalse(result);
		hotelService.bookRoom(user_name, room_number, date_from, date_to);
		query = "SELECT * FROM `bookings` WHERE `guest_id` = (SELECT `u_id` FROM `users` WHERE `u_login` = '" + user_name 
				+ "') AND `room_id` = (SELECT `r_id` FROM `rooms` WHERE `r_number` = '" + room_number 
				+ "') AND `date_from` = '" + date_from + "' AND `date_to` = '" + date_to + "'";
		resultSet = statement.executeQuery(query);
		result = resultSet.next();
		resultSet.close();
		Assert.assertTrue(result);
	}
	
	@DataProvider
	public Object[][] unbooking_room() {
		return new Object[][] {
	    new Object[] { "user01", 101, new Date(1000)},
	  };
	}
	
	@Test(dataProvider = "unbooking_room")
	public void unBookRoom(String user_name, int room_number, Date date_from) throws ServiceException, SQLException {
		String query = "SELECT * FROM `bookings` WHERE `guest_id` = (SELECT `u_id` FROM `users` WHERE `u_login` = '" + user_name 
					+ "') AND `room_id` = (SELECT `r_id` FROM `rooms` WHERE `r_number` = '" + room_number 
					+ "') AND `date_from` = '" + date_from + "'";
		ResultSet resultSet = statement.executeQuery(query);
		boolean result = resultSet.next();
		resultSet.close();
		Assert.assertTrue(result);
		hotelService.unBookRoom(user_name, room_number, date_from);
		query = "SELECT * FROM `bookings` WHERE `guest_id` = (SELECT `u_id` FROM `users` WHERE `u_login` = '" + user_name 
				+ "') AND `room_id` = (SELECT `r_id` FROM `rooms` WHERE `r_number` = '" + room_number 
				+ "') AND `date_from` = '" + date_from + "'";
		resultSet = statement.executeQuery(query);
		result = resultSet.next();
		resultSet.close();
		Assert.assertFalse(result);
	}
	
	@DataProvider
	public Object[][] guest_info() {
		return new Object[][] {
	    new Object[] { 101, new Date(1000), "Fname1", "Lname1", "111-11-11"},
	  };
	}
	
	@Test(dataProvider = "guest_info")
	public void showGuestInfo(int room_number, Date date, String fName, String lName, String phone) throws ServiceException, SQLException {
		Guest guest = hotelService.showGuestInfo(room_number, date);
		Assert.assertEquals(guest.getFName(), fName);
		Assert.assertEquals(guest.getLName(), lName);
		Assert.assertEquals(guest.getPhone(), phone);
	}
}
