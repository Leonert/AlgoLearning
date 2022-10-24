public class Generics<T, E, G> {

	T object;
	E object2;
	G object3;

	Generics(T object, E object2, G object3) {
		this.object = object;
		this.object2 = object2;
		this.object3 = object3;
	}

	T getObject() {
		return object;
	}

	void show() {
		System.out.println("Type of T:" + object.getClass().getName());
		System.out.println("Type of T:" + object2.getClass().getName());
		System.out.println("Type of T:" + object3.getClass().getName());
	}

}
