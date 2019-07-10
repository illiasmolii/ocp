package ocp.ch5.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class InstantTest {

	public static void main(String[] args) throws InterruptedException {
		Instant before = Instant.now();
		TimeUnit.SECONDS.sleep(2);
		System.out.println(Duration.between(before, Instant.now()));

		System.out.println(
				ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.systemDefault()).toInstant()
		);

		System.out.println(
				Instant.ofEpochSecond(1_000_000)
		);

		System.out.println(
				Instant.now().plus(1, ChronoUnit.DAYS)
		);

		System.out.println(
				Instant.now().plus(1, ChronoUnit.MONTHS) // Month & Years - exception
		);
	}
}
