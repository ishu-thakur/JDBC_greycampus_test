package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReadRecords {
	public ArrayList<Customer_details> getAllData() {

		Connection connection = null;
		Statement createStatement = null;
		ResultSet resultSet = null;
		ArrayList<Customer_details> customerList = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "abc");
			createStatement = connection.createStatement();
			resultSet = createStatement.executeQuery("select * from customer_details");
			customerList = new ArrayList<Customer_details>();
			while (resultSet.next()) {
				Customer_details customer_details = new Customer_details();
				customer_details.setCid(resultSet.getInt("cid"));
				customer_details.setFristname(resultSet.getString("firtname"));
				customer_details.setLastname(resultSet.getString("lastname"));
				customer_details.setStreet(resultSet.getString("street"));
				customer_details.setCity(resultSet.getString("city"));
				customer_details.setState(resultSet.getString("state"));
				customer_details.setZipcode(resultSet.getInt("zipcode"));
				customer_details.setProdut_name(resultSet.getString("product_name"));
				customer_details.setCreated_by(resultSet.getString("created_by"));
				customer_details.setCreated_on(resultSet.getDate("created_on"));
				customer_details.setUpdated_by(resultSet.getString("updated_by"));
				customer_details.setUpdated_on(resultSet.getDate("updated_on"));
				customerList.add(customer_details);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			try {
				createStatement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			try {
				resultSet.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return customerList;
	}
}
