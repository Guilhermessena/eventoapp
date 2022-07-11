package com.api.booking;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.booking.model.BookingModel;
import com.api.booking.repository.BookingRepository;
import com.api.booking.service.BookingService;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

	@TestConfiguration
	static class BookingTestServiceConfiguration {

		@Bean
		public BookingService bookingService() {
			return new BookingService();
		}

	}

	@Autowired
	BookingService bookingService;

	@MockBean
	BookingRepository bookingRepository;

	@Test
	public void BookingTestServiceDaysCalculator() {
		String name = "Guilherme";
		int days = bookingService.daysCalculatorWihtDatabase(name);

		Assertions.assertEquals(days, 10);
	}

	@Before
	public void setup() {
		LocalDate checkIn = LocalDate.parse("2020-11-10");
		LocalDate checkOut = LocalDate.parse("2020-11-20");
		BookingModel bookingModel = new BookingModel("1", "Guilherme", checkIn, checkOut, 2);

		Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
				.thenReturn(java.util.Optional.of(bookingModel));
	}

}
