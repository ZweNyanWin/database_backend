package net.physiqueForge.ems.dto.client;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClientResponseDTO extends MasterClientDTO {
    private LocalDate dob;
    private double height;
    private double weight;
    private String goal;
    private String clientStatus;  // Stored as String
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}