package ocp.ch9;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) throws URISyntaxException {
		String testTxt = "src/main/resources/test.txt";
		Path path = Paths.get(testTxt);
		Path same = Paths.get("src", "main", "resources", "test.txt");
//		Path uri = Paths.get(new URI("http://google.com"));
		Path uriFile = Paths.get(new URI("file:////home/user/workspace/ocp/src/main/resources/test.txt")); // should be absolute

		URI fromPath = uriFile.toUri();

		Path path1 = FileSystems.getDefault().getPath(testTxt); // similar to Paths.get
		System.out.println(path.equals(path1)); // true

		Path fromFile = new File(testTxt).toPath();
		System.out.println(fromFile.equals(path)); // true
		File fileFromPath = fromFile.toFile();
	}
}
