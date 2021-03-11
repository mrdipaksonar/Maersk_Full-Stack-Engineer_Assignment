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

	@PostMapping("/checkAvailable")
	public ResponseBody checkAvailable(
			@Valid @org.springframework.web.bind.annotation.RequestBody RequestBody maerskRequestBody) {

		ResponseBody maerskResponseBody = iContainerBookingService.checkAvailable(maerskRequestBody);
		return maerskResponseBody;
	}

	@PostMapping("/saveBooking")
	public ResponseBody saveBooking(
			@Valid @org.springframework.web.bind.annotation.RequestBody RequestBody maerskRequestBody) {

		ResponseBody maerskResponseBody = iContainerBookingService.saveBooking(maerskRequestBody);
		return maerskResponseBody;
	}
}