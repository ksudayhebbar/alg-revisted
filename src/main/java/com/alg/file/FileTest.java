package com.alg.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileTest {

	public static List<String> reader(String file) throws IOException {

		return Files.readAllLines(Paths.get(file));
	}

	public static void write(String file, List<String> data) throws IOException {
		Path path = Paths.get(file);
		if (Files.notExists(path)) {
			path = Files.createFile(path);
		}

		Files.write(path, data, StandardOpenOption.APPEND);

	}

	public static void main(String[] args) throws IOException {

		List<String> d = new ArrayList<String>();
		d.add("aaa");
		d.add("aaa");
		d.add("aaa");
		d.add("aaa");
		d.add("aaa");
		d.add("aaa");
		write("C:\\New folder\\test.txt", d);
		List<String> reader = reader("C:\\New folder\\test.txt");
		System.err.println(reader);
	}

}
