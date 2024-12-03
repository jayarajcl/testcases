<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


Enter User ID User ID: 


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ViewProfileServlet {
public void doGet(HttpServletRequest request) {
String userId = request.getParameter("userId");
try {
// IDOR vulnerability: No authorization check
String profile = "SELECT * FROM users WHERE id=" + userId;
System.out.println(profile);
} catch (Exception e) {
e.printStackTrace();
}
}
}
