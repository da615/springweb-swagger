package com.adam;

//import com.adam.config.RuleProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication

public class SpringbootApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApp.class,args);
    }
}
