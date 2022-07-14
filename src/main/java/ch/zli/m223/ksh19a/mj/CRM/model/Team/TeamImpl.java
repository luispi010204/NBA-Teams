package ch.zli.m223.ksh19a.mj.CRM.model.Team;

import ch.zli.m223.ksh19a.mj.CRM.model.City.CityImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.PlayerImpl;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Team")
public class TeamImpl implements Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @ManyToOne
    private PlayerImpl player;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<CityImpl> cities;


    protected TeamImpl() {
        /* for JPA only*/
        cities = new ArrayList<>();

    }

    public TeamImpl(String name, PlayerImpl player) {
        this();
        this.name = name;
        this.player = player;

    }


    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void addCityToList(CityImpl city) {
        cities.add(city);
    }


}
