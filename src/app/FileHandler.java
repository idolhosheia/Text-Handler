package app;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class FileHandler {

    public String createFile(String path) {
        Path newFile;
        try {
            newFile = Files.createFile(Paths.get(path));
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something wrong: " + e.getMessage();
        }
        return "Created " + newFile;
    }

    public String writeToFile(String path, String content) {
        try {
            Files.write(Paths.get(path), content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            return "Error writing to file: " + e.getMessage();
        }
        return "Recorded in " + path;
    }

    public String readFromFile(String path) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return "Error reading from file: " + e.getMessage();
        }
    }
}

