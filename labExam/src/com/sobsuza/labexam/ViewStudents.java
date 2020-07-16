package com.sobsuza.labexam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewStudents
 */
@WebServlet("/list")
public class ViewStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String html  = "<h1>LIST OF STUDENTS<h1>";
		html += "<a href='/labExam'>Add New</a>";
		String table = "<table border='1'>";
		table += "<tr>";
		table += "<th>Registration No</th>";
		table += "<th>Name</th>";
		table += "<th>Grade</th>";
		table += "</tr>";
		
		// Load Driver
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
    	try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM students");
			
			while (rs.next()) {
				String reg_no = rs.getString("reg_no");
		    	String name = rs.getString("name");
		    	String grade = rs.getString("grade");
		    	
		    	table += "<tr>";
		    	table += "<td>" + reg_no + "</td>";
		    	table += "<td>" + name + "</td>";
		    	table += "<td>" + grade + "</td>";
		    	table += "</tr>";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	table += "</table>";
    	out.println(html + table);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
