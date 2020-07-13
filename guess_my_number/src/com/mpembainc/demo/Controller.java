package com.mpembainc.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected int numberOfGuess = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected String processInput(int input) {
    	int hiddenNumber = 64;
    	String message = "";
    	
    	if (input > hiddenNumber) {
    		message = "No, that's too high. Guess again.";
    		this.numberOfGuess += 1;
    	} else if(input < hiddenNumber) {
    		message = "No, that's too low. Guess again.";
    		this.numberOfGuess += 1;
    	} else {
    		message = "That's right! You guessed my number in only " + (this.numberOfGuess + 1) + " tries! Would you like to play again?";
    		this.numberOfGuess = 0;
    	}
    	
    	return message;
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String enteredUsername = request.getParameter("username");
		
		if (session.isNew()) {
			session.setAttribute("username", enteredUsername);
		} else {
			@SuppressWarnings("unused")
			String user = (String)session.getAttribute("username");
		}
		
		int input = Integer.parseInt(request.getParameter("user-input"));
		String message = this.processInput(input);
	
		out.println(message);
	}

}
