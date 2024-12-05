<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>View User Profile</title>
</head>
<body>
    <h2>Enter User ID</h2>
    <form action="ViewProfileServlet" method="get">
        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="userId"><br><br>
        <input type="submit" value="View Profile">
    </form>
</body>
</html>

import javax.servlet.http.HttpServletRequest;

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
