package com.serverlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sq")
public class SquareServlet extends HttpServlet   {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		PrintWriter out = res.getWriter();
//		HttpSession session = req.getSession();
		
//		int k = (int) session.getAttribute("k");
//		session.removeAttribute("k");
		
		int k = 0;
		Cookie[] cookies = req.getCookies();
		for(Cookie c: cookies) {
			if (c.getName().equals("k")) {
				k = Integer.parseInt(c.getValue());
			}
		}
		k = k*k;
		out.println("<html><body bgcolor='green'>");
		out.printf("Squared value is cookie: %d", k);
		out.print("</body></html>");
	}
}
