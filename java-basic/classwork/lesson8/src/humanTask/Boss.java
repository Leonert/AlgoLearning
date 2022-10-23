package humanTask;

public class Boss extends Human{
	@Override
	public void live() {
		System.out.println("Boss alive");
	}

	public void work(){
		System.out.println("Boss working");
	}
}
