package com.sparks.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadTestDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadTestDatabase.class);

    // All CommandLineRunner Beans get run once Application context is loaded
    // this specific runner will request a copy of the MessageRepository
    @Bean
    CommandLineRunner initDatabase(MessageRepository repository) {
        return args -> {
            // these two lines will store 2 new Messages in the MessageRepository
            log.info("Preloading " + repository.save(new Message("Nevada", "This is the Nevada GET response.")));
            log.info("Preloading " + repository.save(new Message("Louisiana", "This is the Louisiana GET response.")));
        };
    }
}