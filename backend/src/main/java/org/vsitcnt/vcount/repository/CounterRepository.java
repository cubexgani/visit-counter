package org.vsitcnt.vcount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vsitcnt.vcount.entity.VisitStats;

public interface CounterRepository extends JpaRepository<VisitStats, Integer> {
}
