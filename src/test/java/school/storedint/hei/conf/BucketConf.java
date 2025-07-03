package school.storedint.hei.conf;

import org.springframework.test.context.DynamicPropertyRegistry;
import school.storedint.hei.PojaGenerated;

@PojaGenerated
public class BucketConf {

  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("aws.s3.bucket", () -> "dummy-bucket");
  }
}
