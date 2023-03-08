package dev.keter;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class ScraperApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScraperApplication.class, args);
    }

    @PostConstruct
    public void init() {
        // Set default time zone
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}