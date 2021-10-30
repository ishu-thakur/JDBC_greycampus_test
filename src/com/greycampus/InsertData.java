package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

	public static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "abc");
			prepareStatement = connection
					.prepareStatement("insert into customer_details values(?,?,?,?,?,?,?,?,?,?,?,?)");
			prepareStatement.setInt(1, 1);
			prepareStatement.setString(2, "xyz");
			prepareStatement.setString(3, "klm");
			prepareStatement.setString(4, "near school");
			prepareStatement.setString(5, "Chennai");
			prepareStatement.setString(6, "Tamil Nadu");
			prepareStatement.setInt(7, 160022);
			prepareStatement.setString(8, "alexa");
			prepareStatement.setString(9, "xyz");
			prepareStatement.setDate(10, getCurrentDate());
			prepareStatement.setString(11, "abc");
			prepareStatement.setDate(12, getCurrentDate());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			try {
				prepareStatement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	}

}
