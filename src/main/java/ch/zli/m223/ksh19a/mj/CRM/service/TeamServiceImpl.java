package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19a.mj.CRM.exception.NotFoundException;
import ch.zli.m223.ksh19a.mj.CRM.exception.UserAlreadyExistsException;
import ch.zli.m223.ksh19a.mj.CRM.model.City.City;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.PlayerImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;
import ch.zli.m223.ksh19a.mj.CRM.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;
    private Player player;

    @Override
    public List<Team> getAllTeams() {
        return new ArrayList<>(teamRepository.findAll());
    }

    @Override
    public Team getTeam(Long id) {
        return teamRepository.findById(id).orElseThrow(() -> { throw new NotFoundException("There was no user with the id given.");
        });
    }

    @Override
    public Player insertTeam(String name) {
        if (name == null)
            throw new InvalidArgumentException("Name must not be null");
        if (teamRepository.findTeamByName(name).isPresent()) {
            throw new UserAlreadyExistsException("Team with name" + name + " already exists");
        }
        return (Player) teamRepository.insert(name, player);
    }

    @Override
    public Long deleteTeam(String name) {
        return null;
    }
}
