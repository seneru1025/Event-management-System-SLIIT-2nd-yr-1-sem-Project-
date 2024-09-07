<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
    <title>Event Details</title>
    <link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<div class="nav-bar">
              <div class="nav-logo">
                  <h1>Event Management System</h1>
              </div>
              <div class="nav-link-profile">
                  <a href="profile"> <img src="assets/images/profile.png" alt="Italian Trulli"></a>
              </div>
          </div>
          <div class="home-content-main-container">
              <div class="home-content-container">
             	 <h2>Event Details</h2>
             	 
             	 <div class="event-details-main-container">
             	 <div class="event-details-container">
             	 	<h3>${event.eventname}</h3>
				    <p>Date: ${event.eventDate}, Time: ${event.eventTime}</p>
				
				    <!-- Display other event details -->
				    <p>Event Type: ${event.eventType}</p>
				    <p>Location: ${event.expectLocation}</p>
				    <p>Number of Attendees: ${event.numAttendees}</p>
				
				    <!-- Display boolean values as Yes or No -->
				    <p>Food & Beverages: ${event.foodBev ? 'Yes' : 'No'}</p>
				    <p>Audio Visual: ${event.audioVisual ? 'Yes' : 'No'}</p>
				    <p>Accommodation: ${event.accommodation ? 'Yes' : 'No'}</p>
				
				    <!-- Display event description -->
				    <p>Event Description: ${event.eventDescription}</p>
				
					<div class="event-details-btns">
						<a id="btn-back" href="EventsServlet">Back to Events</a>
						<a id="btn-edit" href="EditEventServlet?eventId=${event.id}">Edit Event details</a>
						<a id="btn-delete" href="DeleteEventsServlet?eventId=${event.id}">Delete Event details</a>
					    
				</div>
             	 </div>
             	 	
				
             	 </div>
			    
              </div>
            </div>
    
</body>
</html>
