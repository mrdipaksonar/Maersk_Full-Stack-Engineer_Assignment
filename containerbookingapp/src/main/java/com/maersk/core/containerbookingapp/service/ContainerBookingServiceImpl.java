package com.maersk.core.containerbookingapp.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import com.maersk.core.containerbookingapp.entity.Bookings;
import com.maersk.core.containerbookingapp.model.ContainerType;
import com.maersk.core.containerbookingapp.model.RequestBody;
import com.maersk.core.containerbookingapp.model.ResponseBody;
import com.maersk.core.containerbookingapp.model.ServiceResponseBody;
import com.maersk.core.containerbookingapp.repository.IBookingsRepository;

/**
 * @purpose ContainerBookingServiceImpl.
 *
 * @author sonar
 */

public class ContainerBookingServiceImpl implements IContainerBookingService {

	@Autowired
	IBookingsRepository iBookingsRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestTemplate restTemplate;

	@Value("${url.external.service}")
	private String uri;

	@Override
	public ResponseBody checkAvailable(RequestBody maerskRequestBody) {

		ResponseBody ResponseBody = new ResponseBody();
		ResponseBody.setAvailable(true);

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<RequestBody> entity = new HttpEntity<RequestBody>(maerskRequestBody, headers);

			ServiceResponseBody result = restTemplate.exchange(uri, HttpMethod.POST, entity, ServiceResponseBody.class)
					.getBody();

			if (result.getAvailableSpace() == 0) {
				ResponseBody.setAvailable(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseBody;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public ResponseBody saveBooking(RequestBody maerskRequestBody) {

		ResponseBody ResponseBody = new ResponseBody();

		try {
			Bookings bookings = new Bookings();

			bookings.setContainerSize(maerskRequestBody.getContainerSize());
			bookings.setContainerType(
					String.valueOf(ContainerType.valueOf(maerskRequestBody.getContainerType().toString())));
			bookings.setDestination(maerskRequestBody.getDestination());
			bookings.setOrigin(maerskRequestBody.getOrigin());
			bookings.setQuantity(maerskRequestBody.getQuantity());
			bookings.setTimestamp(maerskRequestBody.getTimestamp());

			Bookings _booking = iBookingsRepository.save(bookings);
			ResponseBody.setBookingRef((_booking.getId()));
		} catch (Exception e) {
			logger.error("Exception : ", e.getMessage());
			ResponseBody.setExceptionMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());

		}
		return ResponseBody;
	}
}