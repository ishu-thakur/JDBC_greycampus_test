package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRecord {

		public static void main(String[] args) {
			Connection connection = null;
			PreparedStatement prepareStatement = null;
			try {
				
//				************************Don't run it as i will delete the record entered************************
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "abc");
				prepareStatement = connection.prepareStatement(
						"delete from product_details where cid =1");
				
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

