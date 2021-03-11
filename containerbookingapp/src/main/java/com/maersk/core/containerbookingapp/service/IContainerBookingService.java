package com.maersk.core.containerbookingapp.service;

import com.maersk.core.containerbookingapp.model.RequestBody;
import com.maersk.core.containerbookingapp.model.ResponseBody;

/**
 * @purpose IContainerBookingService.
 *
 * @author sonar
 */

public interface IContainerBookingService {

	public ResponseBody checkAvailable(RequestBody maerskRequestBody);

	public ResponseBody saveBooking(RequestBody maerskRequestBody);
}