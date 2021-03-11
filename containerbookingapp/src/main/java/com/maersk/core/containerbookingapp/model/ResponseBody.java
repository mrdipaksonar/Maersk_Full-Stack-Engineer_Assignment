package com.maersk.core.containerbookingapp.model;

import javax.validation.constraints.Size;

/**
 * @purpose ResponseBody.
 *
 * @author sonar
 */

public class ResponseBody {

	private boolean available;

	@Size(min = 9, max = 9)
	private String bookingRef;

	private String exceptionMessage;

	public ResponseBody() {
	}

	public ResponseBody(boolean b) {
	}

	public ResponseBody(boolean available, @Size(min = 9, max = 9) String bookingRef) {
		this.available = available;
		this.bookingRef = bookingRef;
	}

	public String getBookingRef() {
		return bookingRef;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setBookingRef(String bookingRef) {
		this.bookingRef = bookingRef;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}