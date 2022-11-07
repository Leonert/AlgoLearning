import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIoStreams {
	public static void main(String[] args) {

		Person tom = new Person("Tom", 32, 189.12, false, null);

		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("tom.bin"))) {

			dos.writeUTF(tom.name);
			dos.writeInt(tom.age);
			dos.writeDouble(tom.weight);
			dos.writeBoolean(tom.married);

			dos.writeUTF(tom.name);
			dos.writeInt(tom.age);
			dos.writeDouble(tom.weight);
			dos.writeBoolean(tom.married);

			dos.writeUTF(tom.name);
			dos.writeInt(tom.age);
			dos.writeDouble(tom.weight);
			dos.writeBoolean(tom.married);
			System.out.println("Writed");

		} catch (IOException e) {
			System.out.println(e);
		}


		try (DataInputStream dis = new DataInputStream(new FileInputStream("tom.bin"))) {

			for (int i = 0; i < 3; i++) {
				String name = dis.readUTF();
				int age = dis.readInt();
				double weight = dis.readDouble();
				boolean married = dis.readBoolean();

				System.out.printf("name: %s, age: %d, weight: %f, married: %b\n", name, age, weight, married);
			}

		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
