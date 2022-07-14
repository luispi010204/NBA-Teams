package ch.zli.m223.ksh19a.mj.CRM.model.Player;

import ch.zli.m223.ksh19a.mj.CRM.model.City.City;
import ch.zli.m223.ksh19a.mj.CRM.model.Role.Role;
import ch.zli.m223.ksh19a.mj.CRM.model.Role.RoleImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;

import java.util.List;

public interface Player {
    public Long getID();

    public String getName();

    public String getPasswordHash();

    public List<Role> getRoles();

    public List<Team> getTeams();

    public List<City> getCities();

    void addRoleToList(RoleImpl role);

    String getPlayers();

}
