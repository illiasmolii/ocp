package ocp.ch5.i18n;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateFormatting {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.of(date, time);

		System.out.println(date.format(DateTimeFormatter.ISO_DATE));
		System.out.println(time.format(DateTimeFormatter.ISO_TIME));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_DATE_TIME));

		DateTimeFormatter mediumDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		System.out.println(mediumDate.format(date));		// Jul 13, 2019
		System.out.println(date.format(mediumDate));		// Jul 13, 2019
		System.out.println(mediumDate.format(dateTime));	// Jul 13, 2019
//		System.out.println(mediumDate.format(time));		// UnsupportedTemporalTypeException
		System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))); // 7/13/19 9:22 AM

		// FormatStyle.LONG and FormatStyle.FULL have timezones
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
		// Saturday, July 13, 2019 9:25:09 AM EEST

//		July 13, 09:27
		System.out.println(DateTimeFormatter.ofPattern("MMMM dd, hh:mm").format(LocalDateTime.now()));
	}
}
