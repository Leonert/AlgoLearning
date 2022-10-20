public class Vehicle {


	private enum Month {
		JULY,
		JUNE,
		SEPTEMBER,
		MAY
	}

	private final int size;
	int abc = 5;
	private static int a = 4;
	private int length;

	{
		int abc = 4;
		System.out.println("Non static block");
	}


	static {
		System.out.println("Static block");
	}

	public Vehicle(int size) {
		this.size = size;

		System.out.println("Constructor");
	}

	private int fillLength() {
		int result = 4;

		//.....

		return result;
	}
}
