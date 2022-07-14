package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;

import java.util.List;

public interface PlayerService {
    List<Player> getAllPlayers();

    Player getPlayer(Long id);

    Player insertPlayer(String name, String password);

    Long deletePlayer(String name);
}
