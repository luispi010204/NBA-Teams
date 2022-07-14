package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeams();

    Team getTeam(Long id);

    Player insertTeam(String name);

    Long deleteTeam(String name);
}
