package net.physiqueForge.ems.dto.trainer;

import lombok.*;
import net.physiqueForge.ems.model.AdminUser;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerResponseDTO extends MasterTrainerDTO {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private AdminUser createdBy;
    private AdminUser updatedBy;

}
