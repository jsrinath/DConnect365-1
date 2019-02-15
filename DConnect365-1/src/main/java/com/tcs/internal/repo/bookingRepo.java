package com.tcs.internal.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcs.internal.models.BookingDetails;

public interface bookingRepo extends MongoRepository<BookingDetails,String>{
	BookingDetails findBypatientName(String Patient_Name);
}