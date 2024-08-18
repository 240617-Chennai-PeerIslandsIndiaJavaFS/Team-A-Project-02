package org.revature.springboot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.revature.springboot.dao.RoleRepository;
import org.revature.springboot.model.Role;
import org.revature.springboot.model.User;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @Test
    void testGetAllRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1L, "Role 1", new HashSet<>()));
        roles.add(new Role(2L, "Role 2", new HashSet<>()));

        when(roleRepository.findAll()).thenReturn(roles);

        List<Role> result = roleService.getAllRoles();

        assertEquals(roles, result);
        verify(roleRepository).findAll();
    }

    @Test
    void testGetRoleById() {
        Role role = new Role(1L, "Role 1", new HashSet<>());

        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));

        Role result = roleService.getRoleById(1L);

        assertEquals(role, result);
        verify(roleRepository).findById(1L);
    }

    @Test
    void testCreateRole() {
        Role role = new Role(null, "Role 1", new HashSet<>());

        when(roleRepository.save(role)).thenReturn(new Role(1L, "Role 1", new HashSet<>()));

        Role result = roleService.createRole(role);

        assertEquals(new Role(1L, "Role 1", new HashSet<>()), result);
        verify(roleRepository).save(role);
    }

    @Test
    void testUpdateRole() {
        Role role = new Role(1L, "Role 1", new HashSet<>());

        when(roleRepository.save(role)).thenReturn(role);

        Role result = roleService.updateRole(role);

        assertEquals(role, result);
        verify(roleRepository).save(role);
    }

    @Test
    void testDeleteRole() {
        roleService.deleteRole(1L);

        verify(roleRepository).deleteById(1L);
    }

    @Test
    void testGetUsersByRoleId() {
        Role role = new Role(1L, "Role 1", new HashSet<>());
        User user1 = new User(1L, "User 1");
        User user2 = new User(2L, "User 2");
        role.setUsers(new HashSet<>(List.of(user1, user2)));

        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));

        Set<User> result = roleService.getUsersByRoleId(1L);

        assertEquals(new HashSet<>(List.of(user1, user2)), result);
        verify(roleRepository).findById(1L);
    }
}
