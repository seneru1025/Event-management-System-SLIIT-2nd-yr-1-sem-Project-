<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Event</title>
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
        var phone = document.getElementById('phone');
        var email = document.getElementById('email');
        var foodBeverages = document.getElementById('foodBeverages');
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
              	<h2>Create Event</h2>
              	<div class="event-details-main-container">
             	 <div class="event-details-container">
             	 	<div class ="edit-details-form">
	             	 	<form action="CreateEventServlet" method="post" onsubmit="return onSubmit()">
	             	 	<div>
	             	 		<label for="eventName">Event Name:</label>
				    		<input type="text" name="eventName" id="eventName">
	             	 	</div>
				    	<div>
				    		<label for="eventType">Event Type:</label>
				    		<input type="text" name="eventType" id="eventType">
				    	</div>
				    	<div>
				    		<label for="eventDate">Event Date:</label>
				    		<input type="date" name="eventDate" id="eventDate">
				    	</div>
				    	<div>
				    		<label for="eventTime">Event Time:</label>
				    		<input type="time" name="eventTime" id="eventTime">
				    	</div>
				    	<div>
				    		<label for="expectLocation">Location:</label>
				    		<input type="text" name="expectLocation" id="expectLocation">
				    	</div>
				    	<div>
				    		<label for="numAttendees">Number of Attendees:</label>
				    		<input type="number" name="numAttendees" id="numAttendees">
				    	</div>
				    	<div>
				    		<label for="eventDescription">Event Description:</label>
				    		<textarea name="eventDescription" id="eventDescription"></textarea>
				    	</div>
				    	<div>
				    		<label for="foodBeverages">Food & Beverages:</label>
				    		<input type="checkbox" name="foodBeverages" id="foodBeverages">
				    	</div>
				    	<div>
				    		<label for="audioVisual">Audio Visual:</label>
				    		<input type="checkbox" name="audioVisual" id="audioVisual">
				    	</div>
				    	<div>
				    		<label for="accommodation">Accommodation:</label>
				    		<input type="checkbox" name="accommodation" id="accommodation">
				    	</div>
				    	<div>
				    		<label for="phone">Contact Number:</label>
				    		<input type="text" name="phone" id="phone">
				    	</div>
				    	<div>
				    		<label for="email">Email:</label>
				    		<input type="text" name="email" id="email">
				    	</div>
				    	
				    	<div id="edit-event-submit-btn">
			       			<button type="submit">Create Event</button>
			       		</div>
				         
				    </form>
				    </div>
             	 </div></div>
			    
              </div>
              </div>
    
</body>
</html>