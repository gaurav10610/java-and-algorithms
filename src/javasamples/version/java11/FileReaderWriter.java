package javasamples.version.java11;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderWriter {

	public static void main(String[] args) throws IOException, URISyntaxException {
		URL filePath = FileReaderWriter.class.getClassLoader().getResource("data\\sample-file.txt");

		String fileContent = Files.readString(Path.of(filePath.toURI()));

		System.out.print(fileContent);
	}
}
