package ch.zli.m223.ksh19a.mj.CRM.repository;

import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.PlayerImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Role.RoleImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.TeamImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<PlayerImpl, Long> {

    default Player insert(String name, String password) {
        PlayerImpl player = new PlayerImpl(name, password);
        return save(player);
    }

    Optional<PlayerImpl> findPlayerByName(String name);

    Long deletePlayerByName(String name);
}
