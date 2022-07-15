package ch.zli.m223.ksh19a.mj.CRM.model.Player;

import ch.zli.m223.ksh19a.mj.CRM.model.City.City;
import ch.zli.m223.ksh19a.mj.CRM.model.City.CityImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Role.Role;
import ch.zli.m223.ksh19a.mj.CRM.model.Role.RoleImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.TeamImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "Player")
@SuppressWarnings("serial")
public class PlayerImpl implements Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String email;
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<RoleImpl> roles;

    private String passwordHash;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<TeamImpl> teams;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<CityImpl> cities;


    protected PlayerImpl() {
        /* for JPA only*/
        teams = new ArrayList<>();
        roles = new ArrayList<>();
        cities = new ArrayList<>();
    }

    @ManyToOne
    private TeamImpl team;

    public PlayerImpl(String name, String password) {
        this();
        this.name = name;
        roles = new ArrayList<>();

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.passwordHash = bCryptPasswordEncoder.encode(password);
    }



    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }


    @Override
    public List<Role> getRoles() {
        return new ArrayList<>(roles);
    }

    @Override
    public List<Team> getTeams() {
        return new ArrayList<>(teams);
    }

    @Override
    public List<City> getCities() {
        return new ArrayList<>(cities);
    }

    @Override
    public void addRoleToList(RoleImpl role) {
        roles.add(role);
    }

    public void addTeamToList(TeamImpl team) {
        teams.add(team);
    }

    public void addCityToList(CityImpl city) {
        cities.add(city);
    }




    @Override
    public String getPlayers() {
        return null; //players
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}


