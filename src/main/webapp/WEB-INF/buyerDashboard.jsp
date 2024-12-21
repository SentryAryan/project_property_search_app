<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buyer Dashboard</title>
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
        position: relative;
    }
    nav {
        background-color: #ff1493; /* DeepPink */
        padding: 10px;
        text-align: center; /* Center the navigation bar */
    }
    nav ul {
        list-style-type: none;
        padding: 0;
        display: inline-block; /* Make the ul inline-block */
    }
    nav ul li {
        display: inline-block; /* Change to inline-block for better alignment */
        margin-right: 10px;
        position: relative; /* For dropdown positioning */
    }
    nav ul li a {
        color: white;
        text-decoration: none;
        padding: 5px 10px;
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
        padding: 10px;
        border-radius: 5px;
        list-style-type: none;
        min-width: 200px; /* Set a minimum width for better alignment */
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Add a shadow for better visibility */
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
        padding: 5px 10px;
        background-color: #ff69b4; /* HotPink */
        border-radius: 5px;
        white-space: nowrap; /* Prevent text from wrapping */
    }
    nav ul li ul li a:hover {
        background-color: #ff1493; /* DeepPink */
    }
    section {
        padding: 20px;
        display: flex;
        justify-content: center; /* Center the section content */
    }
    .search-form {
        text-align: center; /* Center the form content */
    }
    .card-container {
        display: flex;
        justify-content: space-around;
        margin-top: 20px;
    }
    .card {
        background-color: #f8f8f8;
        border: 1px solid #ddd;
        border-radius: 5px;
        width: 30%;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        text-align: center;
        padding: 10px;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
    }
    .card img {
        max-width: 100%;
        height: 200px; /* Set a fixed height for all images */
        object-fit: cover; /* Ensure images cover the area without distortion */
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
    .social-media {
        margin-top: 10px;
    }
    .social-media a {
        margin: 0 10px;
        color: #ff69b4; /* Reddish-pink color */
        text-decoration: none;
    }
    .social-media a img {
        vertical-align: middle;
        margin-right: 5px;
    }
    .profile-icon {
        position: absolute;
        top: 20px;
        right: 20px;
    }
    .profile-icon img {
        width: 40px; /* Adjust the size as needed */
        height: 40px; /* Adjust the size as needed */
        border-radius: 50%;
    }
</style>
</head>
<body>
    <header>
        <h1>Buyer Dashboard</h1>
        <div class="profile-icon">
            <a href="buyerProfile"><img src="https://th.bing.com/th/id/OIP.nMdQ_VCIvfsX9k5fy-4vzQHaJ9?w=141&h=189&c=7&r=0&o=5&dpr=1.5&pid=1.7" alt="Profile" /></a>
        </div>
    </header>
    <nav>
        <ul>
            <li><a href="addInquiryForm">Add Inquiry</a></li>
            <li><a href="addFavoriteForm">Add to Favourite</a></li>
            <li><a href="scheduleVisitForm">Schedule a Visit</a></li>
        </ul>
    </nav>
    <section>
        <div class="search-form">
            <h2>Search Properties by Location</h2>
            <form action="searchProperties" method="get">
                <label for="location">Location:</label>
                <input type="text" id="location" name="location">
                <button type="submit">Search</button>
            </form>
        </div>
    </section>
    <footer>
        <p>&copy; 2024 Apna Ghar. All rights reserved.</p>
        <p>Your cozy corner on the web!</p>
    </footer>
</body>
</html>