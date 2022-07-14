package ch.zli.m223.ksh19a.mj.CRM.init;

import ch.zli.m223.ksh19a.mj.CRM.cities.AppCities;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;
import ch.zli.m223.ksh19a.mj.CRM.players.AppPlayers;
import ch.zli.m223.ksh19a.mj.CRM.repository.CityRepository;
import ch.zli.m223.ksh19a.mj.CRM.repository.RoleRepository;
import ch.zli.m223.ksh19a.mj.CRM.repository.PlayerRepository;
import ch.zli.m223.ksh19a.mj.CRM.repository.TeamRepository;
import ch.zli.m223.ksh19a.mj.CRM.roles.AppRoles;
import ch.zli.m223.ksh19a.mj.CRM.teams.AppTeams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ServerInitializer implements ApplicationRunner {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private CityRepository cityRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        Player james = playerRepository.insert(AppPlayers.LEBRON, "6");
        roleRepository.insert(AppRoles.SF, james);
        //Player davis = playerRepository.insert(AppPlayers.DAVIS, "23");
        //roleRepository.insert(AppRoles.SF, davis);

        Player steph = playerRepository.insert(AppPlayers.CURRY, "30");
        roleRepository.insert(AppRoles.PG, steph);
        //Player thompson = playerRepository.insert(AppPlayers.THOMPSON, "11");
        //roleRepository.insert(AppRoles.SG, thompson);

        Player dame = playerRepository.insert(AppPlayers.DAME, "0");
        roleRepository.insert(AppRoles.PG, dame);
        //Player cj = playerRepository.insert(AppPlayers.CJ, "3");
        //roleRepository.insert(AppRoles.SG, cj);


        Team lakers = teamRepository.insert(AppTeams.LAL, james);
        //teamRepository.insert(AppTeams.LAL, james);
        //teamRepository.insert("Los Angeles Lakers", davis);
        //teamRepository.insert(AppTeams.LAL, davis);

        //teamRepository.insert("Warriors", steph);
        Team warriors = teamRepository.insert(AppTeams.GSW, steph);
        //teamRepository.insert("Warriors", thompson);
        //teamRepository.insert(AppTeams.GSW, thompson);

       // teamRepository.insert("Portland Trail Blazers", dame);
        Team blazers = teamRepository.insert(AppTeams.PTB, dame);
        //teamRepository.insert("Portland Trail Blazers", cj);
        //teamRepository.insert(AppTeams.PTB, cj);

        cityRepository.insert(AppCities.LA, lakers);
        cityRepository.insert(AppCities.SANFRACISCO, warriors);
        cityRepository.insert(AppCities.PORTLAND, blazers);

    }
}
