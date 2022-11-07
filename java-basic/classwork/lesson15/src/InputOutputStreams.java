import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputOutputStreams {

	public static void main(String[] args) {
		String text = "фывапр";  // string for output

		// write data to file.txt

		try (FileOutputStream fos = new FileOutputStream("file.txt")) {

			byte[] buffer = text.getBytes();
			fos.write(buffer);
			System.out.println("File created");

		} catch (IOException e) {
			System.out.println("Exception");
		}


		// read data from file.txt

		try (FileInputStream fis = new FileInputStream("file.txt")) {

			System.out.printf("File size: %d bytes \n", fis.available());
			int i = -1;

			while ((i = fis.read()) != -1) {
				System.out.println((char) i);
			}


		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		// read/write from file2.txt

		try (FileInputStream fin = new FileInputStream("file.txt");
			 FileOutputStream fos = new FileOutputStream("file2.txt")) {

			byte[] buffer = new byte[fin.available()];

			// read buffer
			fin.read(buffer, 0, buffer.length);

			// write to file
			fos.write(buffer, 0, buffer.length);


		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}
}
