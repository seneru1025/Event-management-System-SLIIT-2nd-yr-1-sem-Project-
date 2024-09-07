<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="ISO-8859-1">
    <title>Home</title>
    <link href="css/styles.css" rel="stylesheet">
    </head>
    <body>
    <div class="nav-bar">
        <div class="nav-logo">
            <h1>Event Management System</h1>
        </div>
        <div class="nav-link-events"><a href="events">Events</a></div>
        <div class="nav-link-profile">
             <a href="profile"> <img src="assets/images/profile.png" alt="Italian Trulli"></a>
        </div>
    </div>
    <div class="home-content-main-container">
        <div class="home-content-container">
            <h2>Welcome, <%= session.getAttribute("username") %></h2> 
        </div>
    </div>
    </body>
    </html>