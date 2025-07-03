package school.storedint.hei.conf;

import org.springframework.test.context.DynamicPropertyRegistry;
import school.storedint.hei.PojaGenerated;

@PojaGenerated
public class EmailConf {

  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("aws.ses.source", () -> "dummy-ses-source");
  }
}
