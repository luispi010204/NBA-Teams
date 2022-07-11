package ch.zli.m223.ksh19a.mj.CRM.model;

import javax.persistence.*;

@Entity(name = "AppUser")
public class AppUserImpl implements AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;


    protected AppUserImpl() { /* for JPA only*/}

    public AppUserImpl(String name) {
        super();
        this.name = name;
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

}
