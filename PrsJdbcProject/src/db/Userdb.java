package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.User;

public class Userdb {
	public static ArrayList<User> getAll(){
		ArrayList<User> users = new ArrayList<>();
		String sql = "SELECT * FROM user";
		
		try (
			Connection connection = PrsDb.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		) {
			while(rs.next()) {
				// parse User info from rs
				
				User u = parseUserFromResultSet(rs);
				
				users.add(parseUserFromResultSet(rs));
			}
		}
		catch (SQLException sqle) {
			System.err.println(sqle);
			users = null;
		}
		return users;
	}
	
	public static User getById(int id) {
		User user = null;
		String sql = "SELECT * FROM user WHERE Id = ?";
		
		try(
			Connection connection = PrsDb.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = parseUserFromResultSet(rs);
			}
			rs.close();
		}
		catch (SQLException sqle) {
			System.err.println(sqle);
		}
		
		return user;
	}
	
	private static User parseUserFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("Id");
		String firstname = rs.getString("Firstname");
		String lastname = rs.getString("Lastname");
		String username = rs.getString("Username");
		String password = rs.getString("Password");
		String phone = rs.getString("Phone");
		String email = rs.getString("Email");
		boolean rvw = rs.getBoolean("Reviewer");
		boolean admin = rs.getBoolean("Admin");
		
		User u = new User(id, username, password, firstname, lastname, phone, email, rvw, admin);
		return u;
	}
	
	public static boolean add(User user) {
		boolean success = false;
		
		String sql = "INSERT INTO User (Username, Password, " +
				"FirstName, LastName, Phone, Email, Reviewer, Admin)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		
		try (
			Connection connection = PrsDb.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)
		) {
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getEmail());
			ps.setBoolean(7, user.isReviewer());
			ps.setBoolean(8, user.isAdmin());
			
			ps.executeUpdate();
			success = true;
		} catch (SQLException sqle) {
			System.err.println(sqle);
		}
		
		return success;
	}
	
	//skipping update
	
	public static boolean delete(int id) {
		boolean success = false;
		String sql = "DELETE FROM user WHERE Id = ?";
		
		try (
				Connection connection = PrsDb.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)
		) {
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected != 0) {
				success = true;
			}
		}
		catch (SQLException sqle) {
			System.err.println(sqle);
		}
		
		return success;
	}
}
