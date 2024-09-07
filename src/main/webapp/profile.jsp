<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="ISO-8859-1">
    <title>User Profile</title>
    <link href="css/styles.css" rel="stylesheet">
    </head>
    <body>
        <div class="nav-bar">
            <div class="nav-logo">
                <h1>Event Management System</h1>
            </div>
            <div class="nav-link-profile">
                <img src="assets/images/profile.png" alt="Italian Trulli">
           </div>
        </div>
        <div class="home-content-main-container">
            <div class="user-profile-main-container">
                <div class="home-content-container">
                <div class="user-profile-container">
                    <div class="profile-content">
                        <h1>User Profile</h1>
                        <c:forEach var="user" items="${user}">
                            <h2>Username: ${user.username}</h2>
                            <div>
                                <p>First Name:</p><p>${user.firstname}</p>
                            </div>
                            <div>
                                <p>Last Name:</p> <p>${user.lastname}</p>
                            </div>
                            <div>
                                <p>Email: </p><p>${user.email}</p>  
                            </div>
                            <div>
                                <p>Phone: </p><p>${user.phone}</p>
                            </div>
                            <div>
                                <p>Address: </p><p>${user.address}</p>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="profile-content2">
                        <div class="profile-logo">
                            <div class="profile-logo-img"></div>
                        </div>
                        <div class="profile-btns">
                            <form action="editprofile" method="get">
                                <input type="submit" value="Edit Profile">
                            </form>
                            <form action="deleteprofile" method="post">
                                <input type="submit" id="btn-delete" value="Delete Profile">
                            </form> 
                        </div>
                    </div>
                   
        
                </div>
            </div>
            </div>
            
        </div>
        
    </body>
    </html>