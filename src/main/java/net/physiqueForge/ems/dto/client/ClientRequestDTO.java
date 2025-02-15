package net.physiqueForge.ems.dto.client;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.physiqueForge.ems.model.constant.WorkoutStatus;
import java.time.LocalDate;


@EqualsAndHashCode(callSuper = true)
@Data
public class ClientRequestDTO extends MasterClientDTO {
    private String encryptedPassword;
    private LocalDate dob;
    private double height;
    private double weight;
    private WorkoutStatus clientStatus;
    private String phoneNumber;
    private String goal;
}