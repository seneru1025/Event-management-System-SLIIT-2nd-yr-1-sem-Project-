package com.EventManagementSystem;

public class Event {
    private int id;
    private String eventname;
    private String eventType;
    private String eventDate;
    private String eventTime;
    private String expectLocation;
    private int numAttendees;
    private String eventDescription;
    private boolean foodBev;
    private boolean audioVisual;
    private boolean accommodation;
    private String phone;
    private String email;
    private String username;
	public Event(int id, String eventname, String eventType, String eventDate, String eventTime, String expectLocation,
			int numAttendees, String eventDescription, boolean foodBev, boolean audioVisual, boolean accommodation,
			String phone, String email, String username) {
		this.id = id;
		this.eventname = eventname;
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.expectLocation = expectLocation;
		this.numAttendees = numAttendees;
		this.eventDescription = eventDescription;
		this.foodBev = foodBev;
		this.audioVisual = audioVisual;
		this.accommodation = accommodation;
		this.phone = phone;
		this.email = email;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public String getEventname() {
		return eventname;
	}
	public String getEventType() {
		return eventType;
	}
	public String getEventDate() {
		return eventDate;
	}
	public String getEventTime() {
		return eventTime;
	}
	public String getExpectLocation() {
		return expectLocation;
	}
	public int getNumAttendees() {
		return numAttendees;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public boolean isFoodBev() {
		return foodBev;
	}
	public boolean isAudioVisual() {
		return audioVisual;
	}
	public boolean isAccommodation() {
		return accommodation;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	
    

    
}
