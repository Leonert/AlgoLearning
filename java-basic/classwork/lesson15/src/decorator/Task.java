package decorator;

public class Task {
	public static void main(String[] args) {
		Developer dev = new TeamLead(new SeniorJavaDeveloper(new JavaDeveloper()));
		System.out.println(dev.doJob());
	}
}
