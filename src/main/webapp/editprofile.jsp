<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Edit Profile</title>
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
            <div class="home-contnet-container">
                <div class="user-profile-container">
                    <div class="edit-profile-container">
                       <h2>Edit Profile</h2>
                    <form action="updateprofile" method="post">

                        <c:forEach var="user" items="${user}">
                            <div class="edit-profile-form">
                               <div>
                                <label for="first_name" class="form-label">First Name :</label>
                                <input type="text" name="first_name" value="${user.firstname}">
                            </div>
                            <div>
                                <label for="last_name" class="form-label">Last Name :</label>
                                <input type="text" name="last_name" value="${user.lastname}">
                            </div>
                            <div>
                                <label for="email" class="form-label">Email :</label>
                                <input type="text" name="email" value="${user.email}">
                            </div>
                            <div>
                                <label for="phone" class="form-label">Phone :</label>
                                <input type="text" name="phone" value="${user.phone}">
                            </div>
                            <div>
                                <label for="address" class="form-label">Address :</label>
                                <input type="text" name="address" value="${user.address}">
                            </div> 
                            </div>
                            <div class="edit-form-btn">
                                <input type="submit" value="Update Profile">
                            </div>
                            

                        </c:forEach>
                    </form> 
                    </div>
                </div>
            </div>
        </div>
    </div>



</body>

</html>