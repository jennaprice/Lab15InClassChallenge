
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesTextFile {

	public static void readFromFile(String directory) {
		Path writeFile = Paths.get(directory);
		File file = writeFile.toFile();

		try {
			FileReader fr = new FileReader(file);
			// this is a buffer and the benefit of using this is to store a block of memory
			// that we can read data from later -- more efficient than Scanner
			BufferedReader reader = new BufferedReader(fr);
			// this is attempting to read the first line from the text document
			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("No countries have been added yet. Please add a country to continue. ");
		}
	}

	public static void writeToFile(String textForFile, String directory) {

		Path writeFile = Paths.get(directory);
		File file = writeFile.toFile();
		createFile(directory);

		try {
			// the true parameter in the FileOutputStream constructor allows us to append to
			// the end of the document, otherwise false will overwrite the entire document
			PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
			out.println(textForFile);
			out.close();

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found here...");
		}
	}

	public static void createFile(String fileString) {
		// the get() method is overloaded, and I can just pass in the name for the file
		// if I want -- if I don't want it to live in a folder
		Path filePath = Paths.get(fileString);
		// this will only happen if the file is not there
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				// System.out.println("Your file was created successfully");
			} catch (IOException e) {
				System.out.println("Something went wrong with the file creation");
				e.printStackTrace();
			}
		}

		//

	}

	public static void createDirectory(String dirString) {
		Path dirPath = Paths.get(dirString);
		// this will only run if the directory/folder is not already there
		if (Files.notExists(dirPath)) {
			try {
				Files.createDirectories(dirPath);
			} catch (IOException e) {
				System.out.println("Something went wrong!");

			}
		}
	}
}