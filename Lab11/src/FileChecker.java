import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class FileChecker {

	public static void main(String args[]) {

		FileChecker checker = new FileChecker();

		Path p1 = Paths.get("C:\\Users\\carol\\OneDrive\\APOLLO\\APOLLO_20171102_1of4.txt");
		Path pRoot = Paths.get("C:\\Users\\carol\\OneDrive\\APOLLO");

		Path p2 = Paths.get("C:\\Users\\carol\\OneDrive\\APOLLO\\APOLLO_20171102_2of4.txt");
		Path p3 = Paths.get("C:\\Users\\carol\\OneDrive\\APOLLO\\APOLLO_20171102_3of4.txt");
		Path p4 = Paths.get("C:\\Users\\carol\\OneDrive\\APOLLO\\APOLLO_20171102_4of4.txt");

		System.out.format("getFileName: %s%n", p1.getFileName());
		System.out.format("getRoot: %s%n", pRoot.getRoot());

		if (checker.fileCorrect(p1) && checker.fileCorrect(p2) && checker.fileCorrect(p3) && checker.fileCorrect(p4)) {
			System.out.println("Files in the folder are valid.");
		} else {
			System.out.println("Files in the folder are invalid.");
		}

	}

	public boolean fileCorrect(Path p) {

		if (Files.isReadable(p) & Files.isExecutable(p) & Files.isRegularFile(p))
			System.out.println("Good!");
		else {
			System.out.println("Not a valid file path!");
			return false;
		}

		// Files.delete(p1);

		String pattern = "of4.txt";
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**" + pattern);

		Path filename = p.getFileName();
		if (matcher.matches(filename)) {
			return true;
		}

		else {
			return false;
		}

	}

}