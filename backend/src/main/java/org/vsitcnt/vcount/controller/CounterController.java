package org.vsitcnt.vcount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vsitcnt.vcount.dto.VisitResponseDTO;
import org.vsitcnt.vcount.entity.VisitStats;
import org.vsitcnt.vcount.repository.CounterRepository;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/counter")
@CrossOrigin(origins = { "${FRONTEND_URL}", "localhost" })
public class CounterController {
    @Autowired
    private CounterRepository repository;

    @PostMapping("/increment")
    public VisitResponseDTO incrementCount() {
        VisitStats stats = repository.findById(1).orElse(new VisitStats(1, 0, LocalDateTime.now()));
        stats.setVisitCount(stats.getVisitCount() + 1);
        stats.setLastVisited(LocalDateTime.now());
        repository.save(stats);
        return new VisitResponseDTO(stats.getVisitCount(), stats.getLastVisited());
    }
    @PostMapping("/reset")
    public VisitResponseDTO resetCount() {
        VisitStats stats = repository.findById(1)
                .orElse(new VisitStats(1, 0, null));

        stats.setVisitCount(0);
        stats.setLastVisited(null);

        repository.save(stats);
        return new VisitResponseDTO(stats.getVisitCount(), stats.getLastVisited());
    }
}
