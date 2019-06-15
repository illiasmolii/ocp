package ocp.ch1._03;

public class Enums {

	public enum Season {
		WINTER {
			public void printHours() {
				System.out.println("9am-3pm");
			}
		},
		SPRING {
			public void printHours() {
				System.out.println("9am-5pm");
			}
		},
		SUMMER,
		FALL;

		public void printHours() {
			System.out.println("9am-7pm");
		}
	}
}