package com.server;

import jakarta.servlet.GenericServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class Exa
 */
@WebServlet("/Exa")
public class Exa extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Exa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		int age=Integer.parseInt(request.getParameter("age"));
		String phone=request.getParameter("phone");
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");

		    out.println("MySQL Driver Loaded Successfully!");

		    String url = "jdbc:mysql://localhost:3306/user";
 
		    try (Connection con = DriverManager.getConnection(
		            url, "root", "root");

		         PreparedStatement ps = con.prepareStatement(
		            "INSERT INTO userdata (firstname, lastname, id, phone) VALUES (?, ?, ?, ?)")) {

		        ps.setString(1, firstname);
		        ps.setString(2, lastname);
		        ps.setInt(3, age);
		        ps.setString(4, phone);

		        int count = ps.executeUpdate();

		        if (count > 0) {
		            out.println("<h2>Registration Successful!</h2>");
		        } else {
		            out.println("Registration Failed");
		        }
		    }

		} catch (SQLException | ClassNotFoundException e) {
		    out.println("Database Error: " + e.getMessage());
		    e.printStackTrace();
		}
		
		
	}

}
