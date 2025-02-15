package net.physiqueForge.ems.service;

import net.physiqueForge.ems.dto.adminUser.AdminUserResponseDTO;
import net.physiqueForge.ems.dto.adminUser.MasterAdminUserDTO;
import java.util.List;

public interface AdminUserService {

    List<AdminUserResponseDTO> getAllAdminUsers();

    MasterAdminUserDTO getAdminUserById(Long id);

    MasterAdminUserDTO createAdminUser(MasterAdminUserDTO MasterAdminUserDTO);

    MasterAdminUserDTO updateAdminUser(Long id, MasterAdminUserDTO MasterAdminUserDTO);

    void deleteAdminUser(Long id);
}
