import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BufferedStreams {

	public static void main(String[] args) {
		String text = "Hello world!";

		byte[] buffer = text.getBytes();

		//ByteArrayInputStream in = new ByteArrayInputStream(buffer);

		try (BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(buffer))) {

			int c;
			while ((c = bis.read()) != -1) {
				System.out.println((char) c);
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
