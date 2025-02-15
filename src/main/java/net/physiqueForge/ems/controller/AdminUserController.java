package net.physiqueForge.ems.controller;

import net.physiqueForge.ems.dto.adminUser.AdminUserRequestDTO;
import net.physiqueForge.ems.dto.adminUser.AdminUserResponseDTO;
import net.physiqueForge.ems.dto.adminUser.MasterAdminUserDTO;
import net.physiqueForge.ems.service.AdminUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin-users")
public class AdminUserController {

    private final AdminUserService adminUserService;

    public AdminUserController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    // Get all admin users
    @GetMapping
    public ResponseEntity<List<AdminUserResponseDTO>> getAllAdminUsers() {
        List<AdminUserResponseDTO> adminUsers = adminUserService.getAllAdminUsers();
        return ResponseEntity.ok(adminUsers);
    }

    // Get a specific admin user by ID
    @GetMapping("/{id}")
    public ResponseEntity<MasterAdminUserDTO> getAdminUserById(@PathVariable Long id) {
        MasterAdminUserDTO adminUser = adminUserService.getAdminUserById(id);
        return ResponseEntity.ok(adminUser);
    }

    // Create a new admin user
    @PostMapping
    public ResponseEntity<MasterAdminUserDTO> createAdminUser(@RequestBody AdminUserRequestDTO MasterAdminUserDTO) {
        MasterAdminUserDTO createdUser = adminUserService.createAdminUser(MasterAdminUserDTO);
        return ResponseEntity.ok(createdUser);
    }

    // Update an admin user
    @PutMapping("/{id}")
    public ResponseEntity<MasterAdminUserDTO> updateAdminUser(
            @PathVariable Long id, @RequestBody AdminUserRequestDTO MasterAdminUserDTO) {
        MasterAdminUserDTO updatedUser = adminUserService.updateAdminUser(id, MasterAdminUserDTO);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete an admin user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdminUser(@PathVariable Long id) {
        adminUserService.deleteAdminUser(id);
        return ResponseEntity.noContent().build();
    }
}