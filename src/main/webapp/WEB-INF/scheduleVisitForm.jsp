<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Schedule Visit</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #ffffff; /* White background */
        color: #333;
    }
    header {
        background-color: #ff69b4; /* HotPink */
        padding: 20px;
        text-align: center;
        color: white;
    }
    section {
        padding: 20px;
        display: flex;
        justify-content: center; /* Center the section content */
    }
    .form-container {
        text-align: center; /* Center the form content */
    }
    footer {
        background-color: #ffffff; /* White background */
        padding: 10px;
        text-align: center;
        color: #333;
        position: fixed;
        width: 100%;
        bottom: 0;
    }
    footer img {
        max-height: 40px; /* Adjust the height as needed */
        vertical-align: middle;
        margin-right: 10px;
    }
</style>
</head>
<body>
<header>
<h1>Schedule a Visit</h1>
</header>
<section>
<div class="form-container">
<form action="scheduleVisit" method="post">
<label for="buyerUsername">Buyer Username:</label>
<input type="text" id="buyerUsername" name="buyerUsername" required><br><br>
<label for="propertyTitle">Property Title:</label>
<input type="text" id="propertyTitle" name="propertyTitle" required><br><br>
<label for="visitDate">Visit Date:</label>
<input type="date" id="visitDate" name="visitDate" required><br><br>
<label for="status">Status:</label>
<select id="status" name="status" required>
<option value="Scheduled">Scheduled</option>
<option value="Completed">Completed</option>
<option value="Cancelled">Cancelled</option>
</select><br><br>
<button type="submit">Schedule Visit</button>
</form>
<br>
<a href="buyerDashboard">Back to Dashboard</a>
</div>
</section>

</body>
</html>
