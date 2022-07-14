package ch.zli.m223.ksh19a.mj.CRM.model.Role;

import ch.zli.m223.ksh19a.mj.CRM.model.Player.PlayerImpl;

import javax.persistence.*;

@Entity(name = "Role")
public class RoleImpl implements Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;

    @ManyToOne
    private PlayerImpl player;

    protected RoleImpl() { /* for JPA only*/}

    public RoleImpl(String role, PlayerImpl player) {
        super();
        this.role = role;
        this.player = player;
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getRole() {
        return role;
    }
}
