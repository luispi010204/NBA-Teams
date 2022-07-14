package ch.zli.m223.ksh19a.mj.CRM.model.City;

import ch.zli.m223.ksh19a.mj.CRM.model.Player.PlayerImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.TeamImpl;

import javax.persistence.*;

@Entity(name = "City")
public class CityImpl implements City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @ManyToOne
    private TeamImpl team;

    @ManyToOne
    protected PlayerImpl player;



    protected CityImpl() {
        /* for JPA only*/

    }

    public CityImpl(String name, TeamImpl team) {
        this();
        this.name = name;
        this.team = team;

    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }


}
