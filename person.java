package Recursion;

class Person {
	String name;
	int year_of_birth;
	boolean isEmployed, isStudent;
	final int CURRENT_YEAR = 2012;

	public Person() {
		this.name = "David Tunnell";
		this.year_of_birth = 1984;
		this.isEmployed = true;
	}

	public Person(String x, int y, boolean z, boolean w) {
		this.name = x;
		this.year_of_birth = y;
		this.isStudent = z;
		this.isEmployed = w;
	}

	public String returnName() {
		return name;
	}

	public int returnYob() {
		return year_of_birth;
	}

	public boolean returnEmployed() {
		return isEmployed;
	}

	public int age() {
		return CURRENT_YEAR - year_of_birth;
	}

	public static double m(int age) {
		double fraction = (1 / (double) age);
		if (age == 0) {
			return 0; // Base Case
		} else {
			return fraction + m(age - 1); // Recursive method feature
		}
	}

	public String returnSentence() {
		if (isEmployed == true && isStudent == true) {
			return "Hello " + name + ". You are employed, a student and \n"
					+ age() + " years old. Time has been kind to you.\n\n"
					+ "And guess what else? Recursion!: " + m(age());
		} else if (isEmployed == true && isStudent == false) {
			return "Welcome " + name
					+ ". You are employed, don't attend school and are \n"
					+ age() + " years old. Time has been kind to you.\n\n"
					+ "And guess what else? Recursion!: " + m(age());
		} else if (isEmployed == false && isStudent == true) {
			return "Welcome " + name
					+ ". You aren't employed, attend school and are \n" + age()
					+ " years old. Time has been kind to you.\n\n"
					+ "And guess what else? Recursion!: " + m(age());
		} else {
			return "Welcome " + name
					+ ". You aren't employed, don't attend school and are \n"
					+ age() + " years old. Time has been kind to you?\n\n"
					+ "And guess what else? Recursion!: " + m(age());
		}
	}

}