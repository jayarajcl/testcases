<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Open Redirect Form</title>
</head>
<body>
    <h2>Redirect to External URL</h2>
    <form action="RedirectServlet" method="get">
        <label for="url">URL:</label>
        <input type="text" id="url" name="url"><br><br>
        <input type="submit" value="Redirect">
    </form>
</body>
</html>

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getParameter("url");
        try {
            // Vulnerable redirect logic without validation
            response.sendRedirect(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
