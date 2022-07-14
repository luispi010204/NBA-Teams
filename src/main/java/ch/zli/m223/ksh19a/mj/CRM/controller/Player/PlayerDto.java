package ch.zli.m223.ksh19a.mj.CRM.controller.Player;


import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.model.Role.Role;

import java.util.ArrayList;
import java.util.List;

public class PlayerDto {

    public Long id;
    public String name;
    public List<String> roles;
    public List<String> teams;
    public List<String> cities;


    public PlayerDto(Player player) {
        id = player.getID();
        name = player.getName();
        roles = new ArrayList<>();
        teams = new ArrayList<>();
        cities = new ArrayList<>();

        for (var role : player.getRoles()) {
            roles.add(role.getRole());
        }

        for (var team : player.getTeams()) {
            teams.add(team.getName());
        }
    }
}
