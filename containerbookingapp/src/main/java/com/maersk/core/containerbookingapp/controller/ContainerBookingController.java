package com.maersk.core.containerbookingapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.maersk.core.containerbookingapp.model.RequestBody;
import com.maersk.core.containerbookingapp.model.ResponseBody;
import com.maersk.core.containerbookingapp.service.IContainerBookingService;

/**
 * @purpose ContainerBookingController.
 *
 * @author sonar
 */

public class ContainerBookingController {

	@Autowired
	IContainerBookingService iContainerBookingService;

	@PostMapping("/api/bookings/checkAvailable")
	public ResponseBody checkAvailable(
			@Valid @org.springframework.web.bind.annotation.RequestBody RequestBody requestBody) {

		ResponseBody maerskResponseBody = iContainerBookingService.checkAvailable(requestBody);
		return maerskResponseBody;
	}

	@PostMapping("/api/bookings/saveBooking")
	public ResponseBody saveBooking(
			@Valid @org.springframework.web.bind.annotation.RequestBody RequestBody requestBody) {

		ResponseBody maerskResponseBody = iContainerBookingService.saveBooking(requestBody);
		return maerskResponseBody;
	}
}
