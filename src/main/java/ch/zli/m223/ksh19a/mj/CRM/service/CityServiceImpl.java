package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.exception.NotFoundException;
import ch.zli.m223.ksh19a.mj.CRM.model.City.City;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;
import ch.zli.m223.ksh19a.mj.CRM.repository.CityRepository;
import ch.zli.m223.ksh19a.mj.CRM.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService{


    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return new ArrayList<>(cityRepository.findAll());
    }

    @Override
    public City getCity(Long id) {
       return cityRepository.findById(id).orElseThrow(() -> { throw new NotFoundException("There was no user with the id given.");
        });
    }

    @Override
    public Team insertCity(String name) {
        return null;
    }

    @Override
    public Long deleteCity(String name) {
        return null;
    }
}
