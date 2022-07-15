package ch.zli.m223.ksh19a.mj.CRM.model.Player;

import ch.zli.m223.ksh19a.mj.CRM.model.City.City;
import ch.zli.m223.ksh19a.mj.CRM.model.Role.Role;
import ch.zli.m223.ksh19a.mj.CRM.model.Role.RoleImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public interface Player extends UserDetails {
    public Long getID();

    public String getName();

    public String getEmail();

    public List<Role> getRoles();

    public List<Team> getTeams();

    public List<City> getCities();

    void addRoleToList(RoleImpl role);

    String getPlayers();

    public String getPassword();

    public String getUsername();

    public Collection<? extends GrantedAuthority> getAuthorities();

    public boolean isAccountNonExpired();

    public boolean isAccountNonLocked();

    public boolean isCredentialsNonExpired();

    public boolean isEnabled();

}
