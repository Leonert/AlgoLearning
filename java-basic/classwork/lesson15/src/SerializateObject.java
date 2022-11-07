import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializateObject {

	public static void main(String[] args) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"))) {

			Person p = new Person("Sam", 33, 178.9, true, new Family("some"));
			Person p1 = new Person("Sam1", 31, 178.9, true, new Family("some1"));
			Person p2 = new Person("Sam2", 32, 178.9, true, new Family("some2"));

			oos.writeObject(p);
			oos.writeObject(p1);
			oos.writeObject(p2);

		} catch (IOException e) {
			System.out.println(e);
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))) {

			Person p = (Person) ois.readObject();
			Person p1 = (Person) ois.readObject();
			Person p2 = (Person) ois.readObject();

			System.out.println(p);
			System.out.println(p1);
			System.out.println(p2);

		} catch (Exception e) {
			System.out.println(e);
		}


	}
}
