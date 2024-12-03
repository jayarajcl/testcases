<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.example.CSRFProtection" %>
<% HttpSession session = request.getSession(); String csrfToken = CSRFProtection.generateCSRFToken(session); %>


Enter a Command Command: 


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

public class CSRFProtection {
public static String generateCSRFToken(HttpSession session) {
String token = UUID.randomUUID().toString();
session.setAttribute("csrf_token", token);
return token;
}

public static boolean validateCSRFToken(HttpServletRequest request) {
    String token = request.getParameter("csrf_token");
    String sessionToken = (String) request.getSession().getAttribute("csrf_token");
    return token != null && token.equals(sessionToken);
}

public void doPost(HttpServletRequest request) {
    if (!validateCSRFToken(request)) {
        throw new SecurityException("Invalid CSRF token");
    }
    String command = request.getParameter("command");
    try {
        // Command injection vulnerability
        Runtime.getRuntime().exec(command);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
