package ocp.ch5.datetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationTest {

	public static void main(String[] args) {
		System.out.println(Duration.ofSeconds(2)); // PT2S - PT is Period of Time
		System.out.println(Duration.ofMinutes(90)); // PT1H30M
		System.out.println(Duration.of(90, ChronoUnit.MINUTES)); // PT1H30M
		System.out.println(LocalTime.now().plus(Duration.ofHours(1)));
		System.out.println(ChronoUnit.MINUTES.between(LocalTime.of(23, 30), LocalTime.now()));
	}
}
