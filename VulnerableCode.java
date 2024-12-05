<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


Search Search Query: 


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
out.println("

You searched for: " + query + "

");
} catch (Exception e) {
e.printStackTrace();
}
}
}
