package com.masai.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
public ErrorDetails(LocalDateTime now, String message2, String description) {
		// TODO Auto-generated constructor stub
	}
public LocalDateTime getTimestamp() {
	return timestamp;
}
public void setTimestamp(LocalDateTime timestamp) {
	this.timestamp = timestamp;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
private LocalDateTime timestamp;
private String message;
private String details;
//getters and setters
}