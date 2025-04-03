package sn.onp.gouv.customer_service.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@ConfigurationProperties(prefix = "global.params")
public class GlobalConfig {
 private int p1;
 private int p2;
}
