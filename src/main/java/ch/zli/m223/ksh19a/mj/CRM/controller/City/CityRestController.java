package ch.zli.m223.ksh19a.mj.CRM.controller.City;


import ch.zli.m223.ksh19a.mj.CRM.controller.Player.PlayerDto;
import ch.zli.m223.ksh19a.mj.CRM.controller.Team.TeamDto;
import ch.zli.m223.ksh19a.mj.CRM.service.CityService;
import ch.zli.m223.ksh19a.mj.CRM.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class CityRestController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<CityDto> getAllCities() {
        return cityService.getAllCities().stream()
                .map(city -> new CityDto(city))
                .collect(Collectors.toList());
    }

    @GetMapping("/cities/{id}")
    public CityDto getCity(@PathVariable("id") Long id) {
        return new CityDto(cityService.getCity(id));
    }

    @PostMapping("/cities")
    public TeamDto insertTeam(@RequestBody CityInputDto cityData) {
        return new TeamDto(cityService.insertCity(cityData.name));
    }

    @DeleteMapping("/cities/{name}")
    public Long deleteTeam(@PathVariable("name") String name) {
        return cityService.deleteCity(name);
    }


   /** @GetMapping("/cities/{id}/teams")
    public List<TeamDto> getTeamsFromCities(@PathVariable("id") Long id) {
        City city = cityService.getCity(id);
        return city.getTeams().stream()
                .map(team -> new TeamDto(team))
                .collect(Collectors.toList());
    }**/


}

