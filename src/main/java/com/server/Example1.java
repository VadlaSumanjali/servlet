package com.server;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Example1
 */
@WebServlet("/Example1")
public class Example1 extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Example1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int a=Integer.parseInt(request.getParameter("a"));
		int b=Integer.parseInt(request.getParameter("b"));
		String ch=request.getParameter("operation");
		switch (ch) {
		case "add" : {
			out.println("addition "+(a+b));
			break;
		}
		case "sub":
			out.println("subtraction "+(a-b));
			break;
		case "mul" : {
			out.println("multiplication "+(a*b));
			break;
		}
		case "div":
			out.println("division "+(a/b));
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + ch);
		}
	}

}
