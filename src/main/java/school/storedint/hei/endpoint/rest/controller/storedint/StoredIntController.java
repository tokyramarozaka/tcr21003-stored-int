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
  public int getStoredInt() throws IOException {
    return service.getIntValue();
  }
}
