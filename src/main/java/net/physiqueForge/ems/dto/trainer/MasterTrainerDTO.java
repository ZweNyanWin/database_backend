package net.physiqueForge.ems.dto.trainer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.physiqueForge.ems.model.AdminUser;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MasterTrainerDTO {
    private String name;
    private String email;
    private String specialization;
    private long experience;
    private AdminUser approvedBy;
}
