package com.dbpack.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
	public static Statement stmt = null;
	public static Connection conn = null;

	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USERNAME = "vinni";
	public static final String PASSWORD = "vinni";

	// Insert records into SCOREBOARD table
	public static void InsertData(int pid, String pname, int pscore) {
		try {

			String insertQuery = "insert into scoreboard values(" + pid + ",'" + pname + "'," + pscore + ")";
			System.out.println("Insert Query: " + insertQuery);

			if (stmt.executeUpdate(insertQuery) == 1)
				System.out.println("Player added successful");
			else
				System.out.println(" Player Insertion Failed");
		} catch (Exception ex) {
			System.out.println("Invalid data");
		}
	}

	// Retrieve records from SCOREBOARD table
	public static void RetriveData(int pid) {
		try {

			String retriveQuery = "Select * from scoreboard where pid = " + pid;
			System.out.println("Retrive Query: " + retriveQuery);

			ResultSet set = stmt.executeQuery(retriveQuery);

			if (set.next() == false) {
				System.out.println(" Given Player's score is not available in the records");
			} else {
				do {
					System.out.println(set.getInt(1) + "---" + set.getString(2) + "---" + set.getInt(3));
				} while (set.next());
			}

		} catch (Exception ex) {
			System.out.println("Exception Occured while Retriving the data from the table");
		}
	}
	
	 
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		Class.forName("com.mysql.jdbc.Driver");

		
		
		// Select an option to perform operation
		while (true) {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the Operation to Perform: 1. Insert  2. Retrive \n");
			int option = Integer.parseInt(br.readLine());
			switch (option) {

			case 1:
				System.out.println("Enter Player Number: \n");
				int pnum = Integer.parseInt(br.readLine());

				System.out.println("Enter Player Name: \n");
				String pname = br.readLine();

				System.out.println("Enter Player Score: \n");
				int pscore = Integer.parseInt(br.readLine());

				InsertData(pnum, pname, pscore);
				break;
			case 2:

				System.out.println("Enter Player Number: \n");

				int pid = Integer.parseInt(br.readLine());

				RetriveData(pid);
				break;
			
			}
			
		
			stmt.close();
			conn.close();
		}
		
		
	}
}
