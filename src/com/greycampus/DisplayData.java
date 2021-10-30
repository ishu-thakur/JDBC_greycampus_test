package com.greycampus;

import java.util.ArrayList;

public class DisplayData {

	public static void main(String[] args) {

		ReadRecords readRecords = new ReadRecords();
		ArrayList<Customer_details> customerData = readRecords.getAllData();
		customerData.forEach(customer -> {
			System.out.println("cid =" + customer.getCid());
			System.out.println("First Name =" + customer.getFristname());
			System.out.println("Last Name =" + customer.getLastname());
			System.out.println("Street Address =" + customer.getStreet());
			System.out.println("City =" + customer.getCity());
			System.out.println("zip code =" + customer.getZipcode());
			System.out.println("Product Name =" + customer.getProdut_name());
			System.out.println("Created By =" + customer.getCreated_by());
			System.out.println("Created On =" + customer.getCreated_on());
			System.out.println("Updated By =" + customer.getUpdated_by());
			System.out.println("Update on =" + customer.getUpdated_on());
		});
	}

}
