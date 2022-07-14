package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.model.City.City;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;


import java.util.List;

public interface CityService {
    List<City> getAllCities();

    City getCity(Long id);

    Team insertCity(String name);

    Long deleteCity(String name);



}
