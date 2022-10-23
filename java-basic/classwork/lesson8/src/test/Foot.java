package test;

public class Foot {
	private final Ball ball;

	public Foot(Ball ball) {
		this.ball = ball;
	}

	public void changeBall(String name) {
		ball.setName(name);
	}

	@Override
	public String toString() {
		return "Foot{" +
				"ball=" + ball +
				'}';
	}
}
