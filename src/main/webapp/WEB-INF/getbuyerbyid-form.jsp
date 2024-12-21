<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Get Buyer by ID</title>
</head>
<body>
    <h2>Get Buyer by ID</h2>
        <form action="getBuyerById" method="get">
        <label for="buyer_id">Buyer ID:</label>
        <input type="text" id="buyer_id" name="buyer_id" required><br><br>
        <input type="submit" value="Get Buyer">
    </form>
</body>
</html>