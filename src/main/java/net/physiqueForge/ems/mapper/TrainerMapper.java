package net.physiqueForge.ems.mapper;
import net.physiqueForge.ems.dto.trainer.MasterTrainerDTO;
import net.physiqueForge.ems.dto.trainer.TrainerResponseDTO;
import net.physiqueForge.ems.model.Trainer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TrainerMapper {
    TrainerMapper INSTANCE = Mappers.getMapper(TrainerMapper.class);

    Trainer toEntity(MasterTrainerDTO masterTrainerDTO);
    MasterTrainerDTO toDto(Trainer trainer);
}

