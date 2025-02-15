package net.physiqueForge.ems.dto.client;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MasterClientDTO {
    private String name;
    private String email;
    private Long createdById;
    private Long updatedById;

}
