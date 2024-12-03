

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search</title>
</head>
<body>
    <h2>Search</h2>
    <form action="SearchServlet" method="get">
        <input type="hidden" name="csrf_token" value="<%= CSRFProtection.generateCSRFToken(request.getSession()) %>">
        <label for="query">Search Query:</label>
        <input type="text" id="query" name="query"><br><br>
        <input type="submit" value="Search">
    </form>
</body>
</html>

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class SearchServlet {
    public void doGet(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
        if (!CSRFProtection.validateCSRFToken(request)) {
            throw new SecurityException("Invalid CSRF token");
        }
        String query = request.getParameter("query");
        try {
            PrintWriter out = response.getWriter();
            // Reflect user input directly without encoding
            out.println("<p>You searched for: " + query + "</p>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

