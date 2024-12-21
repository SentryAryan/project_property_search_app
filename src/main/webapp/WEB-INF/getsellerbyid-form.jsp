<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Get Seller by ID</title>
</head>
<body>
    <h2>Get Seller by ID</h2>
    <form action="getSellerbySellerId" method="get">
        <label for="seller_id">Seller ID:</label>
        <input type="text" id="seller_id" name="seller_id" required><br><br>
        <input type="submit" value="Get Seller">
    </form>
</body>
</html>