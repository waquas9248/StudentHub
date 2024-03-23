package com.app.studenthub.service;

import com.app.studenthub.model.Role;
import com.app.studenthub.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.app.studenthub.util.UserRole;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public List<Role> getAllRolesByType(UserRole type) {
        return roleRepository.findAllByType(type);
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Long id, Role roleDetails) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            Role existingRole = optionalRole.get();
            existingRole.setType(roleDetails.getType());
            return roleRepository.save(existingRole);
        } else {
            throw new RuntimeException("Role not found with id: " + id);
        }
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
