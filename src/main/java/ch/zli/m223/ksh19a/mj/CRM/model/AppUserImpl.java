package ch.zli.m223.ksh19a.mj.CRM.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "AppUser")
public class AppUserImpl implements AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<RoleImpl> roles;


    protected AppUserImpl() {
        /* for JPA only*/
        roles = new ArrayList<>();
    }

    public AppUserImpl(String name) {
        this();
        this.name = name;
        roles = new ArrayList<>();
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
    public void addRoleToList(RoleImpl role) {
        roles.add(role);
    }

}
