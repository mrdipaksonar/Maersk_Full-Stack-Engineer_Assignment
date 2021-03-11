package com.maersk.core.containerbookingapp.model;

/**
 * @purpose ContainerType.
 *
 * @author sonar
 */

public enum ContainerType {
	DRY("Dry"), REEFER("Reefer");

	private String type;

	ContainerType(String type) {
		this.type = type;
	}

	public static boolean contains(String type) {

		for (ContainerType containerType : ContainerType.values()) {
			if (containerType.name().equals(type)) {
				return true;
			}
		}
		return false;
	}
}