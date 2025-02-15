package net.physiqueForge.ems.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@NoArgsConstructor
@Entity
@Table(name = "trainers")
public class Trainer extends MasterData {

    @Column(nullable = false)
    private String name;

    @Column(name = "email" , nullable = false , unique = true)
    private String email;
    private String specialization;
    private long experience;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "approved_by_id")
    private AdminUser approvedBy;





}




