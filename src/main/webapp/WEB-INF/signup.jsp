<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>User Signup</title>
<style>
        body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: url('https://example.com/background-image.jpg') no-repeat center center fixed;
    background-size: cover;
    background-attachment: fixed;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    overflow: hidden;
}
.container {
    background-color: rgba(240, 240, 240, 0.9); /* Changed color */
    padding: 30px; /* Reduced padding */
    border-radius: 15px;
    box-shadow: 0 0 30px rgba(0, 0, 0, 0.1);
    transition: transform 0.3s, box-shadow 0.3s;
    width: 350px; /* Reduced width */
    max-width: 90%;
    text-align: center; /* Centered the card */
}
.container:hover {
    transform: scale(1.05);
    box-shadow: 0 0 35px rgba(0, 0, 0, 0.2);
}
h2 {
    color: #333333;
    text-align: center;
    margin-bottom: 20px; /* Reduced margin */
    font-size: 24px; /* Reduced font size */
}
.form-group {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    margin-bottom: 15px; /* Reduced margin */
}
.form-group label {
    margin-bottom: 5px;
    color: #333333; /* Changed color */
    font-size: 16px;
}
.form-group input, .form-group select {
    width: 100%;
    padding: 12px; /* Reduced padding */
    border: 1px solid #cccccc;
    border-radius: 5px;
    font-size: 16px;
    background-color: #ffffff; /* Changed color */
    color: #333333;
}
button {
    width: 100%;
    padding: 12px; /* Reduced padding */
    background-color: #ff69b4; /* HotPink */
    color: white;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s;
}
button:hover {
    background-color: #ff1493; /* DeepPink */
}
</style>
</head>
<body>
<div class="container">
<h2>User Signup</h2>
 <form action="signup" method="post">
    <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div class="form-group">
        <label for="role">Role:</label>
        <select id="role" name="role" required>
            <option value="Admin">Admin</option>
            <option value="Seller">Seller</option>
            <option value="Buyer">Buyer</option>
        </select>
    </div>
    <button type="submit">Sign Up</button>
</form>
<p>Already have an account? <a href="login">Login here</a></p>
</div>
</body>
</html>