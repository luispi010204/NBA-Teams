package ch.zli.m223.ksh19a.mj.CRM.controller.Team;

import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamDto {
    public Long id;
    public String name;
    //public List<String> players;

    public TeamDto(Team team) {
        id = team.getID();
        name = team.getName();
       /** players = new ArrayList<>();
        for (Player player : team.getPlayers()) {
            players.add(player.getPlayers());
        }**/
    }
}
