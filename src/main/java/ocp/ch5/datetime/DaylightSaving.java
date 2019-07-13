package ocp.ch5.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DaylightSaving {

	public static void main(String[] args) {
		ZoneId easternUs = ZoneId.of("US/Eastern");
		DateTimeFormatter format = DateTimeFormatter.ISO_TIME;
		LocalTime time = LocalTime.of(1, 30);

		LocalDate springDate = LocalDate.of(2016, Month.MARCH, 13);
		ZonedDateTime springZDT = ZonedDateTime.of(springDate, time, easternUs);
		System.out.println(springZDT.format(format));				// 01:30:00-05:00
		System.out.println(springZDT.plusHours(1).format(format));	// 03:30:00-04:00

		LocalDate autumnDate = LocalDate.of(2016, Month.NOVEMBER, 6);
		ZonedDateTime autumnZDT = ZonedDateTime.of(autumnDate, time, easternUs);
		System.out.println(autumnZDT.format(format));				// 01:30:00-04:00
		System.out.println(autumnZDT.plusHours(1).format(format));	// 01:30:00-05:00
		System.out.println(autumnZDT.plusHours(2).format(format));	// 02:30:00-05:00
	}
}
