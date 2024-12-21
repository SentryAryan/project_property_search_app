<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visit Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #ffffff; /* White background */
        color: #333;
        display: flex;
        justify-content: center; /* Center the body content */
        align-items: center; /* Center the body content vertically */
        height: 100vh; /* Full viewport height */
        margin: 0;
        overflow: hidden; /* Prevent scrollbars */
    }
    .details-container {
        background-color: #f9f9f9;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 90%; /* Adjust width to fit within the viewport */
        max-width: 500px; /* Maximum width for the container */
        box-sizing: border-box; /* Include padding in the element's total width and height */
        text-align: center; /* Center the content */
    }
    .details-container h2 {
        margin-bottom: 20px;
    }
    .details-container p {
        margin: 10px 0;
    }
    .details-container a {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #ff69b4; /* HotPink */
        color: white;
        text-decoration: none;
        border-radius: 5px;
    }
    .details-container a:hover {
        background-color: #ff1493; /* DeepPink */
    }
</style>
</head>
<body>
<div class="details-container">
<h2>Visit Details</h2>
<p>Visit ID: ${visit.visitId}</p>
<p>Buyer ID: ${visit.buyerId}</p>
<p>Property ID: ${visit.propertyId}</p>
<p>Visit Date: ${visit.visitDate}</p>
<p>Status: ${visit.status}</p>
<a href="buyerDashboard">Back to Dashboard</a>
</div>
</body>
</html>