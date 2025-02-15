package net.physiqueForge.ems.service.impl;

import net.physiqueForge.ems.dto.adminUser.AdminUserRequestDTO;
import net.physiqueForge.ems.dto.adminUser.AdminUserResponseDTO;
import net.physiqueForge.ems.dto.adminUser.MasterAdminUserDTO;
import net.physiqueForge.ems.mapper.AdminUserMapper;
import net.physiqueForge.ems.model.AdminUser;
import net.physiqueForge.ems.repository.AdminUserRepository;
import net.physiqueForge.ems.service.AdminUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    private final AdminUserRepository adminUserRepository;
    private final AdminUserMapper adminUserMapper;

    public AdminUserServiceImpl(AdminUserRepository adminUserRepository, AdminUserMapper adminUserMapper) {
        this.adminUserRepository = adminUserRepository;
        this.adminUserMapper = adminUserMapper;
    }

    @Override
    public List<AdminUserResponseDTO> getAllAdminUsers() {
        List<AdminUser> adminUsers = adminUserRepository.findAll();
        return adminUserMapper.toDtoList(adminUsers);
    }

    @Override
    public MasterAdminUserDTO getAdminUserById(Long id) {
        AdminUser adminUser = adminUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AdminUser not found with ID: " + id));
        return adminUserMapper.toDto(adminUser);
    }

    @Override
    public MasterAdminUserDTO createAdminUser(MasterAdminUserDTO masterAdminUserDTO) {
        AdminUser adminUser = adminUserMapper.toEntity((AdminUserRequestDTO) masterAdminUserDTO);
        adminUser = adminUserRepository.save(adminUser);
        return adminUserMapper.toDto(adminUser);
    }

    @Override
    public MasterAdminUserDTO updateAdminUser(Long id, MasterAdminUserDTO MasterAdminUserDTO) {
        AdminUser existingUser = adminUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AdminUser not found with ID: " + id));

        // Map DTO properties to existing entity
        existingUser.setName(MasterAdminUserDTO.getName());
        existingUser.setEmail(MasterAdminUserDTO.getEmail());

        existingUser = adminUserRepository.save(existingUser);
        return adminUserMapper.toDto(existingUser);
    }

    @Override
    public void deleteAdminUser(Long id) {
        AdminUser adminUser = adminUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AdminUser not found with ID: " + id));
        adminUserRepository.delete(adminUser);
    }
}