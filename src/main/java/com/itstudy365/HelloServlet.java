package com.itstudy365;

import java.io.IOException;
import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/tomcat")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected final static Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Accessed to the application.");

        // Check if a session exists
        HttpSession session = request.getSession(false); // Do not create a new session
        if (session == null) {
            // No session exists, create a new one for the first access
            logger.info("No session found. Creating a new session.");
            session = request.getSession(true); // Create a new session
            session.setAttribute("key", "value");
            response.getWriter().println("A new session has been created. Session ID: " + session.getId()
                    + " Served by: " + InetAddress.getLocalHost().getHostName());
            return;
        }

        // If session exists, proceed with normal processing
        logger.info("Session found. Session ID: " + session.getId());
        response.getWriter().println("Session found. Session ID: " + session.getId() + " Served by: "
                + InetAddress.getLocalHost().getHostName());
    }
}
