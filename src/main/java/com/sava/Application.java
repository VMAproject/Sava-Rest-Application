package com.sava;

import com.sava.config.JpaConfiguration;
import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@EnableJSONDoc
@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages = "com.sava")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
