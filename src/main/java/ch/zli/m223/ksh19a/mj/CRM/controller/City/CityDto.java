package ch.zli.m223.ksh19a.mj.CRM.controller.City;

import ch.zli.m223.ksh19a.mj.CRM.model.City.City;

public class CityDto {
    public Long id;
    public String name;
    //public List<String> players;

    public CityDto(City city) {
        id = city.getID();
        name = city.getName();
       /** players = new ArrayList<>();
        for (Player player : team.getPlayers()) {
            players.add(player.getPlayers());
        }**/
    }
}
