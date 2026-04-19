package org.vsitcnt.vcount.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.vsitcnt.vcount.entity.VisitStats;
import org.vsitcnt.vcount.repository.CounterRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(CounterRepository repository) {
        return args -> {
            // Check if the record already exists to avoid duplicate errors
            if (!repository.existsById(1)) {
                VisitStats initialStats = new VisitStats();
                initialStats.setId(1);
                initialStats.setVisitCount(0);
                initialStats.setLastVisited(null);

                repository.save(initialStats);
                System.out.println("Database initialized with ID 1");
            }
        };
    }
}
