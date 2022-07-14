package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.model.Role.Role;

import java.util.List;

public interface RoleService {


    List<Role> getAllRoles();

    Role getRole(Long id);

    Role insertRole(String role);

    void deleteRoleById(Long id);

}
