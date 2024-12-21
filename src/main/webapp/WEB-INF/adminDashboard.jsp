<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>AdminDashboard</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #ffffff; /* White background */
    color: #333;
    margin: 0; /* Remove default margin */
    padding: 0; /* Remove default padding */
}
 
header {
    background-color: #ff69b4; /* HotPink */
    padding: 10px; /* Reduce padding */
    text-align: center;
    color: white;
}
 
nav {
    background-color: #ff1493; /* DeepPink */
    padding: 5px; /* Reduce padding */
    text-align: center; /* Center the navigation bar */
}
 
nav ul {
    list-style-type: none;
    padding: 0;
    display: inline-block; /* Make the ul inline-block */
    margin: 0; /* Remove default margin */
}
 
nav ul li {
    display: inline-block; /* Change to inline-block for better alignment */
    margin-right: 5px; /* Reduce margin */
    position: relative; /* For dropdown positioning */
}
 
nav ul li a {
    color: white;
    text-decoration: none;
    padding: 5px; /* Reduce padding */
    background-color: #ff69b4; /* HotPink */
    border-radius: 5px;
    display: block; /* Ensure the link takes up the full space */
}
 
nav ul li a:hover {
    background-color: #ff1493; /* DeepPink */
}
 
nav ul li ul {
    display: none; /* Hide dropdowns initially */
    position: absolute;
    top: 100%; /* Position dropdown below the parent item */
    left: 0;
    background-color: #ff69b4; /* HotPink */
    padding: 5px; /* Reduce padding */
    border-radius: 5px;
    list-style-type: none;
    min-width: 150px; /* Reduce minimum width */
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    /* Add a shadow for better visibility */
    z-index: 1000; /* Ensure dropdown appears above other content */
}
 
nav ul li:hover ul {
    display: block; /* Show dropdown on hover */
}
 
nav ul li ul li {
    display: block;
    margin: 5px 0;
}
 
nav ul li ul li a {
    padding: 5px; /* Reduce padding */
    background-color: #ff69b4; /* HotPink */
    border-radius: 5px;
    white-space: nowrap; /* Prevent text from wrapping */
}
 
nav ul li ul li a:hover {
    background-color: #ff1493; /* DeepPink */
}
 
section {
    padding: 10px; /* Reduce padding */
}
 
.card-container {
    display: flex;
    justify-content: space-around;
    margin-top: 10px; /* Reduce margin */
}
 
.card {
    background-color: #f8f8f8;
    border: 1px solid #ddd;
    border-radius: 5px;
    width: 28%; /* Adjust width to fit better */
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    text-align: center;
    padding: 10px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}
 
.card img {
    max-width: 100%;
    height: 150px; /* Reduce height */
    object-fit: cover;
    /* Ensure images cover the area without distortion */
    border-bottom: 1px solid #ddd;
    padding-bottom: 10px;
}
 
.card h3 {
    margin: 10px 0;
}
 
.card p {
    flex-grow: 1;
}
 
footer {
    background-color: #ffffff; /* White background */
    padding: 5px; /* Reduce padding */
    text-align: center;
    color: #333;
    position: fixed;
    width: 100%;
    bottom: 0;
}
 
footer img {
    max-height: 30px; /* Adjust the height */
    vertical-align: middle;
    margin-right: 10px;
}
 
.tab {
    display: none;
}
 
.tab-content {
    display: none;
    text-align: center;
}
 
.tab-content.active {
    display: block;
}
</style>
<script>
       function showTab(tabId) {
           var tabs = document.getElementsByClassName('tab-content');
           for (var i = 0; i < tabs.length; i++) {
               tabs[i].classList.remove('active');
           }
           document.getElementById(tabId).classList.add('active');
       }
</script>
</head>
<body>
<header>
<h1>Welcome to the AdminDashboard</h1>
</header>
<nav>
<ul>
<li><a href="#" onclick="showTab('buyers')">Manage Buyers</a>
<ul>
<li><a href="getAllBuyers">View All Buyers</a></li>
<li><a href="addNewBuyerForm">Add New Buyer</a></li>
<li><a href="updateBuyerForm">Update Buyer</a></li>
<li><a href="getBuyerByIdForm">Get Buyer by ID</a></li>

</ul></li>
<li><a href="#" onclick="showTab('sellers')">Manage Sellers</a>
<ul>
<li><a href="getAllSellers">View All Sellers</a></li>
<li><a href="addNewSellerForm">Add New Seller</a></li>
<li><a href="updateSellerForm">Update Seller</a></li>
<li><a href="getSellerByIdForm">Get Seller by ID</a></li>
</ul></li>
<li><a href="#" onclick="showTab('properties')">Manage	Properties</a>
<ul>
<li><a href="getAllProperties">View All Properties</a></li>
<li><a href="addNewPropertyForm">Add New Property</a></li>
<li><a href="updatePropertyForm">Update Property</a></li>
<li><a href="getPropertyByIdForm">Get Property by ID</a></li>
</ul></li>
</nav>
<section>
<div class="card-container">
<div class="card">
<img src="https://th.bing.com/th/id/OIP.SeV2cgoHDZrR5TuXT_Bd1AHaE6?rs=1&pid=ImgDetMain" alt="Rs.6,500 onwards">
<h3>Rs.6,500 onwards</h3>
<p>Beautiful 3-bedroom apartment located in the heart of the
                    city. Features modern amenities, spacious living areas, and a
                    stunning view of the skyline.</p>
</div>
<div class="card">
<img src="https://th.bing.com/th/id/OIP.9fIuT1CskMhahnXhM_vu3wHaE8?rs=1&pid=ImgDetMain" alt="Rs.5,500 onwards">
<h3>Rs.5,500 onwards</h3>
<p>Charming 2-bedroom house with a large garden. Perfect for
                    families, this property offers a cozy atmosphere and is close to
                    schools and parks.</p>
</div>
<div class="card">
<img src="https://cf.bstatic.com/xdata/images/hotel/max1024x768/568649602.jpg?k=8149268b3a11077f5ebebd56fb2f3d0298713042ca6ac1a8e0a6f8c4f685b8cd&o=&hp=1" alt="Rs.7,500 onwards">
<h3>Rs.7,500 onwards</h3>
<p>Luxurious 4-bedroom villa with a private pool. Located in a
                    serene neighborhood, this property is ideal for those seeking
                    comfort and privacy.</p>
</div>
</div>
<div id="buyers" class="tab-content"></div>
<div id="sellers" class="tab-content"></div>
<div id="properties" class="tab-content"></div>
</section>
<div class="footer" style="text-align: center;">
<p>&copy; 2024 Apna Ghar. All rights reserved.</p>
<p>Your cozy corner on the web!</p>
</div>
</body>
</html>