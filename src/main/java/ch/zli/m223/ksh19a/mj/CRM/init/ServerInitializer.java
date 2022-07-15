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

        Player admin = playerRepository.insert("Luigi", "420");
        roleRepository.insert(AppRoles.ADMIN, admin);
        roleRepository.insert(AppRoles.USER, admin);

        Player james = playerRepository.insert("Benutzer.Lebron", "6");
        playerRepository.insert(AppPlayers.LEBRON, "6");
        roleRepository.insert(AppRoles.SF, james);
        roleRepository.insert(AppRoles.PG, james);
        roleRepository.insert(AppRoles.PF, james);


        Player steph = playerRepository.insert("Benutzer.Steph", "30");
        playerRepository.insert(AppPlayers.CURRY, "30");
        roleRepository.insert(AppRoles.PG, steph);


        Player dame = playerRepository.insert("Benutzer.Dame", "0");
        playerRepository.insert(AppPlayers.DAME, "0");
        roleRepository.insert(AppRoles.PG, dame);

        Team lakers = teamRepository.insert(AppTeams.LAL, james);

        Team warriors = teamRepository.insert(AppTeams.GSW, steph);

        Team blazers = teamRepository.insert(AppTeams.PTB, dame);


        cityRepository.insert(AppCities.LA, lakers);
        cityRepository.insert(AppCities.SANFRACISCO, warriors);
        cityRepository.insert(AppCities.PORTLAND, blazers);

    }
}
