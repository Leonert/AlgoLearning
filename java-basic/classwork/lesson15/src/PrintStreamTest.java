import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintStreamTest {

	public static void main(String[] args) {
		String text = "Hello world!";

		try (PrintStream printStream = new PrintStream(new FileOutputStream("printStream2.txt", true))) {

			printStream.print("Hello!\n");
			printStream.println("Java!");
			printStream.printf("Name: %s Age: %d\n", "Tom", 31);

			String message = "PrintStream";
			byte[] bytes = message.getBytes();
			printStream.write(bytes);

			System.out.println("Writed.");

		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		try (PrintWriter pw = new PrintWriter(new PrintStream("outputStream2.txt"))) {
			pw.println("Hello");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
