import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIoStream {

	public static void main(String[] args) {


		// Byte array input Stream
		byte[] array1 = new byte[]{123, 1, 5, -24, 13};

		ByteArrayInputStream byteStream = new ByteArrayInputStream(array1);
		int b;
		while ((b = byteStream.read()) != -1) {
			System.out.println(b);
		}
		System.out.println(byteStream.read());

		System.out.println();
		String text = "123456789";
		byte[] array2 = text.getBytes();
		ByteArrayInputStream byteStream2 = new ByteArrayInputStream(array2, 1, 3);

		int b2;
		while ((b2 = byteStream2.read()) != -1) {
			System.out.println((char) b2);
		}


		// Byte array input Stream

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		String text2 = "Hello world";

		byte[] buffer = text2.getBytes();

		try {
			byteArrayOutputStream.write(buffer);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		try(FileOutputStream fos = new FileOutputStream("fileOutput.txt")) {

			byteArrayOutputStream.writeTo(fos);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}
}
