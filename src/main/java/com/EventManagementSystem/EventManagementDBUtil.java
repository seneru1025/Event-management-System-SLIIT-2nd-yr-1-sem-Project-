package com.EventManagementSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EventManagementDBUtil {

	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	 public static boolean insertUser(String firstname, String lastname, String email, String phone, String address, String username, String password) {
	    	
	    	boolean isSuccess = false;
	    	
	    	try {
	    		con = ConnectDB.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "insert into users values (0,'"+firstname+"','"+lastname+"','"+email+"','"+phone+"','"+address+"','"+username+"','"+password+"')";
	    		int rs = stmt.executeUpdate(sql);
	    		
	    		if(rs > 0) {
	    			isSuccess = true;
	    		} else {
	    			isSuccess = false;
	    		}
	    		
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	 	
	    	return isSuccess;
	    }
	 
	 public static boolean exsistUser(String username) {
		  
		 try {
					
			 con = ConnectDB.getConnection();		
			 stmt = con.createStatement();
			 String sql = "select * from users where username='"+username+"'";
			 ResultSet rs = stmt.executeQuery(sql);
					
				if (rs.next()) {
					isSuccess = true;
				} else {
					isSuccess = false;
				}
					
			} catch (Exception e) {
					e.printStackTrace();
				}
				
				return isSuccess;
		  }
	 
	 public static boolean validate(String username, String password) {
			
			try {
				con = ConnectDB.getConnection();
				stmt = con.createStatement();
				String sql = "select * from users where username='"+username+"' and password='"+password+"'";
				rs = stmt.executeQuery(sql);
				
				if (rs.next()) {
					isSuccess = true;
				} else {
					isSuccess = false;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
		}
	 

	 public static List<User> getUser(String userName) {
			
			ArrayList<User> user = new ArrayList<>();
			
			try {
				
				con = ConnectDB.getConnection();
				stmt = con.createStatement();
				String sql = "select * from users where username='"+userName+"'";
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					int id = rs.getInt(1);
					String firstname = rs.getString(2);
					String lastname = rs.getString(3);
					String email = rs.getString(4);
					String phone = rs.getString(5);
					String address = rs.getString(6);
					String username = rs.getString(7);
					String password = rs.getString(8);
					
					User usr = new User(id,firstname,lastname,email,phone,address,username,password);
					user.add(usr);
				}
				
			} catch (Exception e) {
				
			}
			
			return user;	
		}
	 
	 
	 public static boolean updateUser( String firstname, String lastname, String email, String phone, String address, String username) {
	    	
	    	try {
	    		
	    		con = ConnectDB.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "update users set firstname='"+firstname+"',lastname='"+lastname+"',email='"+email+"',phone='"+phone+"',address='"+address+"'"
	    				+ "where username='"+username+"'";
	    		int rs = stmt.executeUpdate(sql);
	    		
	    		if(rs > 0) {
	    			isSuccess = true;
	    		}
	    		else {
	    			isSuccess = false;
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return isSuccess;
	    }
	 
	 
	 public static boolean deleteUser(String username) {
	    	
	    	boolean isSuccess = false;
	    	
	    	try {
	    		
	    		con = ConnectDB.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "delete from users where username='"+username+"'";
	    		int r = stmt.executeUpdate(sql);
	    		
	    		if (r > 0) {
	    			isSuccess = true;
	    		}
	    		else {
	    			isSuccess = false;
	    		}
	    		
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return isSuccess;
	    }
	 
	 
	 	
	 public static boolean insertEvent(String eventName, String eventType, String eventDate, String eventTime,
		             String expectLocation, int numAttendees, String eventDescription,
		             boolean foodBeverages, boolean audioVisual, boolean accommodation,
		             String phone, String email, String username) {
		boolean eventCreated = false;
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
		
		// Assuming 'events' is the name of the table
		String sql = "INSERT INTO events (eventname, eventType, eventDate, eventTime, expectLocation, numAttendees, " +
		"eventDescription, foodBev, audioVisual, accommodation, phone, email, username) " +
		"VALUES ('" + eventName + "','" + eventType + "','" + eventDate + "','" + eventTime + "','" +
		expectLocation + "'," + numAttendees + ",'" + eventDescription + "'," + (foodBeverages ? 1 : 0) + "," +
		(audioVisual ? 1 : 0) + "," + (accommodation ? 1 : 0) + ",'" + phone + "','" + email + "','" + username + "')";
		
			int result = stmt.executeUpdate(sql);
		
			if (result > 0) {
				eventCreated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return eventCreated;
 }
	 
	
	 
	 public static List<Event> getEventsForUser(String userName) {
	        List<Event> events = new ArrayList<>();

	        try {
	            con = ConnectDB.getConnection();
	            stmt = con.createStatement();

	            // Assuming 'events' is the name of the events table
	            String sql = "SELECT * FROM events WHERE username = '" + userName + "'";
	            rs = stmt.executeQuery(sql);

	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String eventname = rs.getString("eventname");
	                String eventType = rs.getString("eventType");
	                String eventDate = rs.getString("eventDate");
	                String eventTime = rs.getString("eventTime");
	                String expectLocation = rs.getString("expectLocation");
	                int numAttendees = rs.getInt("numAttendees");
	                String eventDescription = rs.getString("eventDescription");
	                boolean foodBev = rs.getBoolean("foodBev");
	                boolean audioVisual = rs.getBoolean("audioVisual");
	                boolean accommodation = rs.getBoolean("accommodation");
	                String phone = rs.getString("phone");
	                String email = rs.getString("email");
	                String username = rs.getString("username");
	                
	                Event event = new Event(id, eventname, eventType, eventDate, eventTime, expectLocation, numAttendees, eventDescription, foodBev, audioVisual, accommodation, phone, email, username );

	                events.add(event);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return events;
	    }
	 
	 
	 public static Event getEventById(int eventId) {
		    Event event = null;

		    try {
		        con = ConnectDB.getConnection();
		        stmt = con.createStatement();

		        String sql = "SELECT * FROM events WHERE id = " + eventId;
		        rs = stmt.executeQuery(sql);

		        if (rs.next()) {
		            int id = rs.getInt("id");
		            String eventname = rs.getString("eventname");
		            String eventType = rs.getString("eventType");
		            String eventDate = rs.getString("eventDate");
		            String eventTime = rs.getString("eventTime");
		            String expectLocation = rs.getString("expectLocation");
		            int numAttendees = rs.getInt("numAttendees");
		            String eventDescription = rs.getString("eventDescription");
		            boolean foodBev = rs.getBoolean("foodBev");
		            boolean audioVisual = rs.getBoolean("audioVisual");
		            boolean accommodation = rs.getBoolean("accommodation");
		            String phone = rs.getString("phone");
		            String email = rs.getString("email");
		            String username = rs.getString("username");

		            event = new Event(id, eventname, eventType, eventDate, eventTime, expectLocation, numAttendees, eventDescription, foodBev, audioVisual, accommodation, phone, email, username);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return event;
		}
	 
	 public static boolean updateEvent( int eventId, String eventName, String eventType, String eventDate, String eventTime, String expectLocation, int numAttendees, String eventDescription, Boolean foodBev, Boolean audioVisual, Boolean accommodation ) {
	    	
	    	try {
	    		
	    		con = ConnectDB.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "update events set eventname='"+eventName+"',eventType='"+eventType+"',eventDate='"+eventDate+"',eventTime='"+eventTime+"',expectLocation='"+expectLocation+"',numAttendees='"+numAttendees+"',eventDescription='"+eventDescription+"',foodBev='"+(foodBev ? 1 : 0)+"',audioVisual='"+(audioVisual ? 1 : 0)+"',accommodation='"+(accommodation ? 1 : 0)+"'"
	    				+ "where id='"+eventId+"'";
	    		int rs = stmt.executeUpdate(sql);
	    		
	    		if(rs > 0) {
	    			isSuccess = true;
	    		}
	    		else {
	    			isSuccess = false;
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return isSuccess;
	    }
	 
	 public static boolean deleteEvent(int eventId) {
	    	
	    	boolean isSuccess = false;
	    	
	    	try {
	    		
	    		con = ConnectDB.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "delete from events where id='"+eventId+"'";
	    		int r = stmt.executeUpdate(sql);
	    		
	    		if (r > 0) {
	    			isSuccess = true;
	    		}
	    		else {
	    			isSuccess = false;
	    		}
	    		
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return isSuccess;
	    }

	 
}
