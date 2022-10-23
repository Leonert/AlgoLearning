package humanTask;

public class Test {
	public static void main(String[] args) {
		Boss boss = new Boss();
		Manager manager = new Manager();
		Employee employee = new Employee();

		boss.live();
		boss.work();

		manager.live();
		manager.work();
		manager.documents();

		employee.live();
		employee.work();
		employee.documents();
		employee.writeCode();
	}
}
