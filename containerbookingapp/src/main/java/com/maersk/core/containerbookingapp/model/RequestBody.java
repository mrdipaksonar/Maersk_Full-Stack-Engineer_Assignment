package com.maersk.core.containerbookingapp.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

/**
 * @purpose RequestBody.
 *
 * @author sonar
 */

public class RequestBody {

	@NotNull
	@Min(value = 20)
	@Max(value = 40)
	private int containerSize;

	@NotNull
	private ContainerType containerType;

	@NotNull
	@Size(min = 5, max = 20)
	private String destination;

	@NotNull
	@Size(min = 5, max = 20)
	private String origin;

	@NotNull
	@Min(1)
	@Max(100)
	private int quantity;

	private String timestamp;

	public RequestBody() {
	}

	public RequestBody(@NotNull @Min(value = 20) @Max(value = 40) int containerSize,
			@NotNull ContainerType containerType, @NotNull @Size(min = 5, max = 20) String origin,
			@NotNull @Size(min = 5, max = 20) String destination, @NotNull @Min(1) @Max(100) int quantity,
			String timestamp) {
		this.containerSize = containerSize;
		this.containerType = containerType;
		this.origin = origin;
		this.destination = destination;
		this.quantity = quantity;
		this.timestamp = timestamp;
	}

	public int getContainerSize() {
		return containerSize;
	}

	public ContainerType getContainerType() {
		return containerType;
	}

	public String getDestination() {
		return destination;
	}

	public String getOrigin() {
		return origin;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setContainerSize(int containerSize) {
		this.containerSize = containerSize;
	}

	public void setContainerType(ContainerType containerType) {
		this.containerType = containerType;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
