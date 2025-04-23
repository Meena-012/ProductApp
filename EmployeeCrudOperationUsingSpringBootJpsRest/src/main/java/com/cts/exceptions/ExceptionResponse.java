package com.cts.exceptions;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExceptionResponse {

	private int status;
    private String message;
    private LocalTime time;
    private LocalDate date; // New field for the date
    private String errorDetails;
    public ExceptionResponse() {
		System.out.println("Default constructor from Exception Response");
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	public ExceptionResponse(int status, String message, LocalTime time, LocalDate date, String errorDetails) {
		super();
		this.status = status;
		this.message = message;
		this.time = time;
		this.date = date;
		this.errorDetails = errorDetails;
	}
    
}
