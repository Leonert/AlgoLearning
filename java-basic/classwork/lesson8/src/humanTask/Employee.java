package humanTask;

public class Employee extends Manager{

	@Override
	public void live() {
		System.out.println("Employee alive");
	}

	@Override
	public void work(){
		System.out.println("Employee working");
	}

	@Override
	public void documents(){
		System.out.println("Employee documents");
	}

	public void writeCode(){
		System.out.println("Employee is writing code...");
	}

}
