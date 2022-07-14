package ch.zli.m223.ksh19a.mj.CRM.model.Player;

import ch.zli.m223.ksh19a.mj.CRM.model.Role.Role;
import ch.zli.m223.ksh19a.mj.CRM.model.Role.RoleImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.TeamImpl;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Player")
@SuppressWarnings("serial")
public class PlayerImpl implements Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<RoleImpl> roles;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<TeamImpl> teams;


    protected PlayerImpl() {
        /* for JPA only*/
        teams = new ArrayList<>();
        roles = new ArrayList<>();
    }

    @ManyToOne
    private TeamImpl team;

    public PlayerImpl(String name, String password) {
        this();
        this.name = name;
        roles = new ArrayList<>();

        /**BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.passwordHash = bCryptPasswordEncoder.encode(password);**/
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
    public String getPasswordHash() {
        return null;
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
    public void addRoleToList(RoleImpl role) {
        roles.add(role);
    }

    public void addTeamToList(TeamImpl team) {
        teams.add(team);
    }




    @Override
    public String getPlayers() {
        return null; //players
    }

}
