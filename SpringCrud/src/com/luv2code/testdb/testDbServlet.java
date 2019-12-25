package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class testDbServlet
 */
@WebServlet("/testDbServlet")
public class testDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testDbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//setup connection
		String user = "springstudent";
		String pass = "springstudent";
		String jdbcurl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			PrintWriter out = response.getWriter();
			out.println("connecting to db " + jdbcurl);
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcurl,user,pass);
			out.println("Success!!!");
			myConn.close();
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
			throw new ServletException(exc);
		}
	}

}
