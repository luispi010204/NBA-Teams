package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.exception.NotFoundException;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
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
        return null;
    }

    @Override
    public Long deleteTeam(String name) {
        return null;
    }
}
