package com.sobsuza.labexam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Student
 */
@WebServlet("/student")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	
    	// Parameters
    	String reg_no = request.getParameter("regno");
    	String name = request.getParameter("name");
    	String gender = request.getParameter("gender");
    	String phone = request.getParameter("phone");
    	String email = request.getParameter("email");
    	String reg_status = request.getParameter("status");
    	String grade = request.getParameter("grade");
    	
    	// Load JDBC Driver
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	// Connect to DB
    	Connection conn = null;
    	try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bita", "root", "");
			// out.println("Connected to DB");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("Connection failed");
		}
    	
    	// Insert Data
    	Statement stmt = null;
    	String query = "INSERT INTO students (reg_no, name, gender, phone, email, reg_status, grade) ";
    	query += "VALUES ('"+reg_no+"', '"+name+"', '"+gender+"', '"+phone+"', '"+email+"', '"+reg_status+"', '"+grade+"')";
    	try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			out.println("Student Information saved!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("Something went wrong!");
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * @see processRequest(HttpServletRequest request, HttpServletResponse response)
		 */
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
