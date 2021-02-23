package com.adam.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ASUS
 */
@Configuration
@ConfigurationProperties(prefix = "r")
@PropertySource("classpath:panel.properties")
@Component
public class RuleProperties {
  private String path;
  private String file;

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  @Override
  public String toString() {
    return "RuleProperties{" +
            "path='" + path + '\'' +
            ", file='" + file + '\'' +
            '}';
  }
}