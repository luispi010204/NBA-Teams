package ch.zli.m223.ksh19a.mj.CRM.controller.Team;


import ch.zli.m223.ksh19a.mj.CRM.controller.Player.PlayerDto;
import ch.zli.m223.ksh19a.mj.CRM.controller.Player.PlayerInputDto;
import ch.zli.m223.ksh19a.mj.CRM.controller.Role.RoleDto;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;
import ch.zli.m223.ksh19a.mj.CRM.service.PlayerService;
import ch.zli.m223.ksh19a.mj.CRM.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class TeamRestController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/teams")
    public List<TeamDto> getAllTeams() {
        return teamService.getAllTeams().stream()
                .map(team -> new TeamDto(team))
                .collect(Collectors.toList());
    }

    @GetMapping("/teams/{id}")
    public TeamDto getTeam(@PathVariable("id") Long id) {
        return new TeamDto(teamService.getTeam(id));
    }

    @PostMapping("/teams")
    public PlayerDto insertTeam(@RequestBody TeamInputDto teamData) {
        return new PlayerDto(teamService.insertTeam(teamData.name));
    }

    @DeleteMapping("/teams/{name}")
    public Long deleteTeam(@PathVariable("name") String name) {
        return teamService.deleteTeam(name);
    }


   /** @GetMapping("/teams/{id}/players")
    public List<PlayerDto> getPlayersFromTeam(@PathVariable("id") Long id) {
        Team team = teamService.getTeam(id);
        return team.getPlayers().stream()
                .map(player -> new PlayerDto(player))
                .collect(Collectors.toList());
    }**/


}

