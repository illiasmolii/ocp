package ocp.ch5.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class PeriodTest {

	public static void main(String[] args) {
		System.out.println(Period.of(1, 2, 5)); // P1Y2M5D
		System.out.println(Period.ofMonths(10)); // P10M
		System.out.println(Period.ofMonths(-10)); // P-10M
		System.out.println(Period.ofWeeks(2)); // P14D
		System.out.println(LocalDate.now().plus(Period.ofWeeks(2)));
		System.out.println(LocalTime.now().plus(Period.ofWeeks(2))); // exception
	}
}
