package school.storedint.hei.endpoint.rest.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class StoredIntService {
  public int getIntValue() throws IOException {
    var file = new File("tmp/stored-int.txt");
    if (!file.exists()) writeValue(file);

    return readValue(file);
  }

  private int readValue(File file) throws IOException {
    var scanner = new Scanner(file);
    return scanner.nextInt();
  }

  private void writeValue(File file) throws IOException {
    var parentDir = file.getParentFile();
    if (parentDir != null && !parentDir.exists()) {
      if (!parentDir.mkdirs()) {
        throw new IOException(
            "Failed to create parent directories: " + parentDir.getAbsolutePath());
      }
    }
    if (!file.exists() && !file.createNewFile()) {
      throw new IOException("Failed to create file: " + file.getAbsolutePath());
    }

    try (var writer = new FileWriter(file)) {
      writer.write(new Random().nextInt());
    }
  }
}
