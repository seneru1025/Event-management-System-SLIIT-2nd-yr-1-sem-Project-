<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Event</title>
    <link href="css/styles.css" rel="stylesheet">
    <script type="text/javascript">
    function onSubmit() {
        var eventName = document.getElementById('eventName');
        var eventType = document.getElementById('eventType');
        var eventDate = document.getElementById('eventDate');
        var eventTime = document.getElementById('eventTime');
        var expectLocation = document.getElementById('expectLocation');
        var numAttendees = document.getElementById('numAttendees');
        var eventDescription = document.getElementById('eventDescription');
        var foodBeverages = document.getElementById('foodBev');
        var audioVisual = document.getElementById('audioVisual');
        var accommodation = document.getElementById('accommodation');

        if (
            eventName.value === "" ||
            eventType.value === "" ||
            eventDate.value === "" ||
            eventTime.value === "" ||
            expectLocation.value === "" ||
            numAttendees.value === "" ||
            eventDescription.value === "" ||
            phone.value === "" ||
            email.value === ""
        ) {
            alert("All fields are required!");
            return false;
        }
        return true;
    }
</script>
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
              <h2>Update Event</h2>
    			<div class="event-details-main-container">
             	 <div class="event-details-container">
             	 <div class ="edit-details-form">
             	 	<form action="UpdateEventServlet" method="post" onsubmit="return onSubmit()">
			        <input type="hidden" name="eventId" value="${event.id}">
			        <div>
			        	<label for="eventName">Event Name:</label>
			        	<input type="text" id="eventName" name="eventName" value="${event.eventname}">
			        </div>
			        <div>
			        	<label for="eventType">Event Type:</label>
			        	<input type="text" id="eventType" name="eventType" value="${event.eventType}">
			        </div>
			        <div>
			        	<label for="eventDate">Event Date:</label>
			        	<input type="date" id="eventDate" name="eventDate" value="${event.eventDate}">
			        </div>
			        <div>
			        	<label for="eventTime">Event Time:</label>
			        	<input type="time" id="eventTime" name="eventTime" value="${event.eventTime}">
			        </div>
			        <div>
			        	<label for="expectLocation">Location:</label>
			        	<input type="text" id="expectLocation" name="expectLocation" value="${event.expectLocation}">
			        </div>
			        <div>
			        	<label for="numAttendees">Number of Attendees:</label>
			        	<input type="number" id="numAttendees" name="numAttendees" value="${event.numAttendees}">
			        </div>
			        <div>
			        	<label for="eventDescription">Event Description:</label>
			        	<textarea id="eventDescription" name="eventDescription">${event.eventDescription}</textarea>
			        </div>
			        <div>
			        	<label for="foodBev">Food & Beverages:</label>
			        	<input type="checkbox" id="foodBev" name="foodBev" ${event.foodBev ? 'checked' : ''}>
			        </div>
			        <div>
			        	<label for="audioVisual">Audio Visual:</label>
			        	<input type="checkbox" id="audioVisual" name="audioVisual" ${event.audioVisual ? 'checked' : ''}>
			        </div>
			        <div>
			        	<label for="accommodation">Accommodation:</label>
			        	<input type="checkbox" id="accommodation" name="accommodation" ${event.accommodation ? 'checked' : ''}>
			        </div>
			       <div id="edit-event-submit-btn">
			       	<button type="submit">Update Event</button>
			       </div>
			        
			       
			    </form>
             	 </div>
			    
			    
			    <a class="event-edit-back" href="EventDetailsServlet?eventId=${event.id}">Back to Event Details</a>
			    </div></div>
              </div>
          </div>	
    
</body>
</html>