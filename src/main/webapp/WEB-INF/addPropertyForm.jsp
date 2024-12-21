<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Property</title>
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
    .form-container {
        background-color: #f9f9f9;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 90%; /* Adjust width to fit within the viewport */
        max-width: 500px; /* Maximum width for the form */
        box-sizing: border-box; /* Include padding in the element's total width and height */
    }
    .form-container h2 {
        text-align: center;
        margin-bottom: 20px;
    }
    .form-container label {
        margin-top: 10px;
    }
    .form-container input, .form-container textarea {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-sizing: border-box; /* Include padding in the element's total width and height */
    }
    .form-container button {
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #ff69b4; /* HotPink */
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        width: 100%; /* Full width button */
    }
    .form-container button:hover {
        background-color: #ff1493; /* DeepPink */
    }
</style>
</head>
<body>
<div class="form-container">
<h2>Add New Property</h2>
<form action="${pageContext.request.contextPath}/seller/addProperty/${sellerId}" method="post">    <label for="propertyTitle">Property Title:</label>
    <input type="text" id="propertyTitle" name="propertyTitle" required>
    
    <label for="propertyDetails">Property Details:</label>
    <textarea id="propertyDetails" name="propertyDetails" rows="2" required></textarea>
    
    <label for="propertyPrice">Price:</label>
    <input type="number" id="propertyPrice" name="propertyPrice" required>
    
    <label for="propertyLocation">Location:</label>
    <input type="text" id="propertyLocation" name="propertyLocation" required>
    
    <label for="propertySquareft">Square Feet:</label>
    <input type="text" id="propertySquareft" name="propertySquareft" required>
    
    <label for="propertyAmenities">Amenities:</label>
    <textarea id="propertyAmenities" name="propertyAmenities" rows="2" required></textarea>
    
    <button type="submit">Submit</button>
</form>
</div>
</body>
</html>