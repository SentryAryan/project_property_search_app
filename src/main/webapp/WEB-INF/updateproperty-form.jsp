<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Property</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0; /* Light grey background */
            color: #333;
            display: flex;
            justify-content: center; /* Center the body content */
            align-items: center; /* Center the body content vertically */
            height: 100vh; /* Full viewport height */
            margin: 0;
            overflow: hidden; /* Prevent scrollbars */
        }
        .form-container {
            background-color: #ffffff; /* White background */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 90%; /* Adjust width to fit within the viewport */
            max-width: 400px; /* Maximum width for the form */
            box-sizing: border-box; /* Include padding in the element's total width and height */
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #ff69b4; /* HotPink */
        }
        .form-container label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }
        .form-container input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box; /* Include padding in the element's total width and height */
        }
        .form-container input[type="submit"] {
            margin-top: 20px;
            padding: 10px 15px;
            background-color: #ff69b4; /* HotPink */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%; /* Full width button */
            font-size: 14px;
        }
        .form-container input[type="submit"]:hover {
            background-color: #ff1493; /* DeepPink */
        }
</style>
</head>
<body>
<div class="form-container">
<h2>Update Property</h2>
<form action="updateProperty" method="post">
<label for="property_id">Property ID:</label>
<input type="text" id="property_id" name="property_id" required>
<label for="price">Price:</label>
<input type="text" id="price" name="price" required>
<input type="submit" value="Update Property">
</form>
</div>
</body>
</html>