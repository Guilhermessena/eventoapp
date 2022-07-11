package com.api.booking.service;

import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.booking.model.BookingModel;
import com.api.booking.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;

	public int daysCalculatorWihtDatabase(String name) {
		Optional<BookingModel> bookingModelOptional = bookingRepository.findByReserveName(name);
		return Period.between(bookingModelOptional.get().getCheckIn(), bookingModelOptional.get().getCheckOut())
				.getDays();
	}

}
