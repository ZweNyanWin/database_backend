package net.physiqueForge.ems.mapper;

import net.physiqueForge.ems.dto.adminUser.AdminUserRequestDTO;
import net.physiqueForge.ems.dto.adminUser.AdminUserResponseDTO;
import net.physiqueForge.ems.dto.adminUser.MasterAdminUserDTO;
import net.physiqueForge.ems.model.AdminUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminUserMapper {

    AdminUserMapper INSTANCE = Mappers.getMapper(AdminUserMapper.class);

    AdminUserResponseDTO toDto(AdminUser adminUser);

    AdminUser toEntity(AdminUserRequestDTO MasterAdminUserDTO);

    AdminUser toEntity(MasterAdminUserDTO MasterAdminUserDTO);

    List<AdminUserResponseDTO> toDtoList(List<AdminUser> adminUsers);

    List<AdminUser> toEntityList(List<MasterAdminUserDTO> MasterAdminUserDTOs);
}