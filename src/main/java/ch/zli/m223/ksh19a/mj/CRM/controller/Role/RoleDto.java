package ch.zli.m223.ksh19a.mj.CRM.controller.Role;

import ch.zli.m223.ksh19a.mj.CRM.model.Role.Role;

public class RoleDto {
    public String roleName;

    public RoleDto(Role role) {
        this.roleName = role.getRole();
    }
}
