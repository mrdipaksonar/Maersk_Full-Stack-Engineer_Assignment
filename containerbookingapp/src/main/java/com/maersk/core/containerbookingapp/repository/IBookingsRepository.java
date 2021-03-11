package com.maersk.core.containerbookingapp.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.maersk.core.containerbookingapp.entity.Bookings;

/**
 * @purpose IBookingsRepository.
 *
 * @author sonar
 */

public interface IBookingsRepository extends CassandraRepository<Bookings, String> {

}