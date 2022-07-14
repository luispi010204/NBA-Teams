package ch.zli.m223.ksh19a.mj.CRM.repository;

import ch.zli.m223.ksh19a.mj.CRM.model.City.City;
import ch.zli.m223.ksh19a.mj.CRM.model.City.CityImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.PlayerImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.TeamImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<CityImpl, Long> {

    default City insert(String cityName, Team team) {
        TeamImpl teamImpl = (TeamImpl) team;
        CityImpl newCity = new CityImpl(cityName, teamImpl);

        CityImpl saveCity = save(newCity);
        teamImpl.addCityToList(saveCity);
        return saveCity;

    }

    Optional<TeamImpl> findTeamByName(String name);

    Long deleteByName(String name);
}
