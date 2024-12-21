<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Property Search Results</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Search Results for Location: ${location}</h2>
    <form action="filterProperties" method="get">
        <input type="hidden" name="location" value="${location}">
        <label for="minPrice">Min Price:</label>
        <input type="number" id="minPrice" name="minPrice" step="0.01">
        <label for="maxPrice">Max Price:</label>
        <input type="number" id="maxPrice" name="maxPrice" step="0.01">
        <label for="amenities">Amenities:</label>
        <input type="text" id="amenities" name="amenities">
        <button type="submit">Filter</button>
    </form>
    <table>
        <thead>
            <tr>
                <th>Property ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Price</th>
                <th>Location</th>
                <th>Square Feet</th>
                <th>Amenities</th>
                <th>Status</th>
                <th>Seller ID</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="property" items="${properties}">
                <tr>
                    <td>${property.propertyId}</td>
                    <td>${property.title}</td>
                    <td>${property.description}</td>
                    <td>${property.price}</td>
                    <td>${property.location}</td>
                    <td>${property.squareft}</td>
                    <td>${property.amenities}</td>
                    <td>${property.status}</td>
                    <td>${property.sellerId}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
     <br>
            <a href="buyerDashboard">Back to Dashboard</a>
            
         
   
 
</body>
</html>