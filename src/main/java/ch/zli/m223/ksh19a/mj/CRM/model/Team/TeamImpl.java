package ch.zli.m223.ksh19a.mj.CRM.model.Team;

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



    protected TeamImpl() {
        /* for JPA only*/

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


}
