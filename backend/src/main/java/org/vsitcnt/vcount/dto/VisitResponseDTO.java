package org.vsitcnt.vcount.dto;

import java.time.LocalDateTime;

public record VisitResponseDTO(Integer count, LocalDateTime lastVisited) {}
