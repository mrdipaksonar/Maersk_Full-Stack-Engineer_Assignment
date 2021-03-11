package com.maersk.core.containerbookingapp.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @purpose Bookings.
 *
 * @author sonar
 */

@Table
public class Bookings {

	private static final AtomicInteger count = new AtomicInteger(000001);

	private int containerSize;
	private String containerType;
	private String destination;

	@PrimaryKey
	private String id;
	private String origin;
	private int quantity;
	private String timestamp;

	public Bookings() {
		this.id = this.incCount();
	}

	public Bookings(String id, int containerSize, String containerType, String origin, String destination, int quantity,
			String timestamp) {
		this.id = id;
		this.containerSize = containerSize;
		this.containerType = containerType;
		this.origin = origin;
		this.destination = destination;
		this.quantity = quantity;
		this.timestamp = timestamp;
	}

	public static AtomicInteger getCount() {
		return count;
	}

	public int getContainerSize() {
		return containerSize;
	}

	public String getContainerType() {
		return containerType;
	}

	public String getDestination() {
		return destination;
	}

	public String getId() {
		return id;
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

	public String incCount() {
		String init = "957";
		return init.concat(Integer.toString(count.incrementAndGet()));
	}

	public void setContainerSize(int containerSize) {
		this.containerSize = containerSize;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setId(String id) {
		this.id = id;
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