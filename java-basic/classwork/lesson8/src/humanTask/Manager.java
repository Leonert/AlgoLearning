package humanTask;

public class Manager extends Boss{
	@Override
	public void live() {
		System.out.println("Manager alive");
	}

	@Override
	public void work() {
		System.out.println("Manager working");
	}

	public void documents() {
		System.out.println("Manager documents");
	}
}
