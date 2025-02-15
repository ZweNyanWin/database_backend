package net.physiqueForge.ems.model;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import net.physiqueForge.ems.model.constant.WorkoutStatus;
import net.physiqueForge.ems.model.converter.WorkoutStatusConverter;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client extends MasterData {

    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @Column
    private String encryptedPassword;
    @Column
    private LocalDate dob;
    @Column
    private double height;
    @Column
    private double weight;

    @Column
    @Convert(converter = WorkoutStatusConverter.class)
    private WorkoutStatus clientStatus;

    @Column
    private String goal;
}
