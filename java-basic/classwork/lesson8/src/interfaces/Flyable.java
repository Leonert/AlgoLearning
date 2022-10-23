package interfaces;

public interface Flyable {

	default void fly(){
		System.out.println("FLy interface flyeble");
	}

	static void staticFLy(){
		System.out.println("Static fly");
	}
}
