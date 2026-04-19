package org.vsitcnt.vcount.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "visit_stats")
@AllArgsConstructor
@NoArgsConstructor
public class VisitStats {
    @Id
    private Integer id;

    @Column(columnDefinition = "int default 0")
    private Integer visitCount = 0;
    private LocalDateTime lastVisited;
}
