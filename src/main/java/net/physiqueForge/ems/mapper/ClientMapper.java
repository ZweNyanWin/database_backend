package net.physiqueForge.ems.mapper;

import net.physiqueForge.ems.dto.client.ClientRequestDTO;
import net.physiqueForge.ems.dto.client.ClientResponseDTO;
import net.physiqueForge.ems.dto.client.MasterClientDTO;
import net.physiqueForge.ems.model.Client;
import net.physiqueForge.ems.model.constant.WorkoutStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    // Convert Client entity to ClientResponseDTO
    @Mapping(source = "clientStatus", target = "clientStatus", qualifiedByName = "enumToString")
    ClientResponseDTO toDto(Client client);

    MasterClientDTO toMasterDto(Client client);

    // Convert ClientRequestDTO to Client entity
    @Mapping(source = "clientStatus", target = "clientStatus", qualifiedByName = "stringToEnum")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Client toEntity(ClientRequestDTO clientRequestDTO);

    // Convert List of Clients to List of ClientResponseDTOs
    List<ClientResponseDTO> toDtoList(List<Client> clients);

    // Convert Enum to String
    @Named("enumToString")
    default String mapEnumToString(WorkoutStatus status) {
        return (status != null) ? status.name() : null;
    }

    // Convert String to Enum
    @Named("stringToEnum")
    default WorkoutStatus mapStringToEnum(String status) {
        return (status != null) ? WorkoutStatus.valueOf(status) : null;
    }
}