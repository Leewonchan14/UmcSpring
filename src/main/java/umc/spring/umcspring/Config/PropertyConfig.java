package umc.spring.umcspring.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:secret.properties", ignoreResourceNotFound = true)
public class PropertyConfig {

}
