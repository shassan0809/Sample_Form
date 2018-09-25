package com.shreyasPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleHandler
 */
@WebServlet("/SampleHandler")
public class SampleHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		PrintWriter output = response.getWriter();
		String user = request.getParameter("uname");
		int age = Integer.parseInt(request.getParameter("uage"));
		String occupation = request.getParameter("uoccu");
		output.println("\n Name: " +user+ "\n Age: " +age+  "\n occupation: " +occupation+ "\n");
		
		PreparedStatement stmt = null;
		
		try{
			
			if ( (user.equals("")) && (age < 10) ){ //Bad job to terminate process.
				
				System.out.println("Input error. Try again.");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	            rd.forward(request, response);
				
			}else if ( (occupation.equals(""))  ){ //Bad job to add even while having an error.
				
				System.out.println("Loading the driver");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Loaded the driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_shreyas","root","");
				System.out.println("Connection successful");
				String query = "INSERT INTO form(name,age,occupation) VALUES(?,?,?)";
				stmt = conn.prepareStatement(query);
				stmt.setString(1, user);
				stmt.setInt(2, age);
				stmt.setString(3, occupation);
				stmt.executeUpdate();
				output.println("Alert: DB Added while having empty fields.");	
				
			}else if( (!user.equals("")) && (age > 10) && (!occupation.equals(""))) {
				
				System.out.println("Loading the driver");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Loaded the driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_shreyas","root","");
				System.out.println("Connection successful");
				String query = "INSERT INTO form(name,age,occupation) VALUES(?,?,?)";
				stmt = conn.prepareStatement(query);
				stmt.setString(1, user);
				stmt.setInt(2, age);
				stmt.setString(3, occupation);
				stmt.executeUpdate();
				output.println("Status: DB Added.");
			}else {
				
				System.out.println("Something is wrong.");
			}
			
			
		}
		catch(Exception e) {
			System.out.println("This is the error:" +e);
		}
		
		
	}

}
