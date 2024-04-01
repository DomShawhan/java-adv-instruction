package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Vendor;

public class VendorDb {
	public static ArrayList<Vendor> getAllVendors() {
		ArrayList<Vendor> vendors = new ArrayList<>();
		String sql = "SELECT * FROM Vendor";
		
		try(
			Connection connection = PrsDb.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		){
			while(rs.next()) {
				vendors.add(parseVendorFromResultSet(rs));
			}
		}
		catch (SQLException sqle) {
			System.out.println(sqle);
			vendors = null;
		}
		
		return vendors;
	}
	
	public static Vendor getVendorById(int id) {
		Vendor v = null;
		String sql = "SELECT * FROM Vendor WHERE Id = ?";
		
		try (
			Connection connection = PrsDb.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				v = parseVendorFromResultSet(rs);
			}
			
			rs.close();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
		
		return v;
	}
	
	private static Vendor parseVendorFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("Id");
		String code = rs.getString("Code");
		String name = rs.getString("Name");
		String address = rs.getString("Address");
		String city = rs.getString("City");
		String state = rs.getString("State");
		String zip = rs.getString("Zip");
		String phone = rs.getString("Phone");
		String email = rs.getString("Email");
		
		return new Vendor(id, code, name, address, city, state, zip, phone, email);
	}
	
	public static boolean add(Vendor v) {
		boolean success = false;
		String sql = "INSERT INTO Vendor (Code, Name, Address, City, State, Zip, Phone, Email)" +
			"Values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (
			Connection connection = PrsDb.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, v.getCode());
			ps.setString(2, v.getName());
			ps.setString(3, v.getAddress());
			ps.setString(4, v.getCity());
			ps.setString(5, v.getState());
			ps.setString(6, v.getZip());
			ps.setString(7, v.getPhone());
			ps.setString(8, v.getEmail());
			
			ps.executeUpdate();
			success = true;
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
		
		return success;
	}
	
	public static boolean delete(int id) {
		boolean success = false;
		String sql = "DELETE FROM Vendor WHERE Id = ?";
		
		try (
			Connection connection = PrsDb.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected != 0) {
				success = true;
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
		
		return success;
	}
}
