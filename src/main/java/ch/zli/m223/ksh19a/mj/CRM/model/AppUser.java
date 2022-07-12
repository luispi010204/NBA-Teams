package ch.zli.m223.ksh19a.mj.CRM.model;

import java.util.List;

public interface AppUser {
    public Long getID();

    public String getName();

    public String getPasswordHash();

    public List<Role> getRoles();

    void addRoleToList(RoleImpl role);
}
