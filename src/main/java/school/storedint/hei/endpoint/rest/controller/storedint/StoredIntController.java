package school.storedint.hei.endpoint.rest.controller.storedint;

import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import school.storedint.hei.endpoint.rest.service.StoredIntService;

@RestController
@AllArgsConstructor
public class StoredIntController {
  private StoredIntService service;

  @GetMapping("/stored-int")
  public int getStoredInt() {
    try {
      return service.getIntValue();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
