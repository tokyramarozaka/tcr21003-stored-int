package school.storedint.hei.endpoint.rest.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StoredIntService {
  public int getIntValue() throws IOException {
    var file = new File("tmp/stored-int.txt");
    if (!file.exists()) writeValue();

    return readValue(file);
  }

  private int readValue(File file) throws IOException {
    var scanner = new Scanner(file);
    return scanner.nextInt();
  }

  private void writeValue() throws IOException {
    String tmpDir = System.getProperty("java.io.tmpdir");
    if (tmpDir == null || tmpDir.isEmpty()) {
      throw new IOException("java.io.tmpdir is not set");
    }

    File file = new File(tmpDir, "stored-int.txt");

    File tmpDirectory = new File(tmpDir);
    if (!tmpDirectory.exists()) {
      throw new IOException("Temporary directory does not exist: " + tmpDir);
    }
    if (!tmpDirectory.isDirectory()) {
      throw new IOException("Temporary path is not a directory: " + tmpDir);
    }
    if (!tmpDirectory.canWrite()) {
      throw new IOException("Temporary directory is not writable: " + tmpDir);
    }

    try {
      if (!file.exists() && !file.createNewFile()) {
        throw new IOException("Failed to create file: " + file.getAbsolutePath());
      }
    } catch (IOException e) {
      throw new IOException(
          "Error creating file: " + file.getAbsolutePath() + "; " + e.getMessage());
    }

    try (FileWriter writer = new FileWriter(file)) {
      writer.write(String.valueOf(new Random().nextInt()));
    } catch (IOException e) {
      throw new IOException(
          "Error writing to file: " + file.getAbsolutePath() + "; " + e.getMessage());
    }
  }
}
