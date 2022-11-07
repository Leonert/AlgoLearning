import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class FileWriterReader {

	public static void main(String[] args) {

		try (FileWriter writer = new FileWriter("fileWriter.txt")) {

			String text = "Some ~streingsadhjfkgkjsadgfkahsdkfhaksdhfkhasdlkjfhkljasdbflkasdlkfbasldbflhasblfbaskdbfjasbdfjlbasdljfbljhsdabfljhasbdljhfbasdlhfblahsdbflhasdjbfstreingsadhjfkgkjsadgfkahsdkfhaksdhfkhasdlkjfhkljasdbflkasdlkfbasldbflhasblfbaskdbfjasbdfjlbasdljfbljhsdabfljhasbdljhfbasdlhfblahsdbflhasdjbfstreingsadhjfkgkjsadgfkahsdkfhaksdhfkhasdlkjfhkljasdbflkasdlkfbasldbflhasblfbaskdbfjasbdfjlbasdljfbljhsdabfljhasbdljhfbasdlhfblahsdbflhasdjbf";

			writer.write(text);
			writer.append('\n');
			writer.append('E');

			writer.flush();

		} catch (IOException e) {
			System.out.println(e);
		}

		try (FileReader reader = new FileReader("fileWriter.txt")) {

			char[] buff = new char[256];
			int c;
			while ((c = reader.read(buff)) > 0) {
				if (c < 256) {
					buff = Arrays.copyOf(buff, c);
				}
				System.out.println("+");
				System.out.println(buff);
			}

		} catch (IOException e) {
			System.out.println(e);
		}

	}
}
