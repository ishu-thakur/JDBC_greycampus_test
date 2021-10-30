package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRecords {

	public static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "abc");
			prepareStatement = connection.prepareStatement(
					"update customer_details set product_name=?,updated_by = ? ,updated_on=? where cid = ?");
			prepareStatement.setString(1, "qwerty");
			prepareStatement.setString(2, "qw");
			prepareStatement.setDate(3, getCurrentDate());
			prepareStatement.setInt(4, 1);
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
