package ch.zli.m223.ksh19a.mj.CRM.repository;

import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.PlayerImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.TeamImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<TeamImpl, Long> {


    default Team insert(String teamName, Player player) {
        PlayerImpl playerImpl = (PlayerImpl) player;
        TeamImpl newTeam = new TeamImpl(teamName, playerImpl);

        TeamImpl saveTeam = save(newTeam);
        playerImpl.addTeamToList(saveTeam);


        return saveTeam;

    }

    Optional<TeamImpl> findTeamByName(String name);

    Long deleteByName(String name);
}
