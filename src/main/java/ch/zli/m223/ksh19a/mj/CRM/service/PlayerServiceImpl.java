package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19a.mj.CRM.exception.NotFoundException;
import ch.zli.m223.ksh19a.mj.CRM.exception.UserAlreadyExistsException;
import ch.zli.m223.ksh19a.mj.CRM.exception.NotFoundException;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.model.Team.Team;
import ch.zli.m223.ksh19a.mj.CRM.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return new ArrayList<>(playerRepository.findAll());
    }

    @Override
    public Player getPlayer(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("There was no user with the id given.");
        });
    }



    @Override
    public Player insertPlayer(String name, String password) {
        if (name == null) {
            throw new InvalidArgumentException("Name must not be null");
        }
        if (playerRepository.findPlayerByName(name).isPresent()) {
            throw new UserAlreadyExistsException("User with name " + name + " already exists.");
        }

        return playerRepository.insert(name, password);
    }

    @Override
    @Transactional
    public Long deletePlayer(String name) {
        if (name == null) {
            throw new InvalidArgumentException("Name must no be null");
        }
        if (playerRepository.findPlayerByName(name).isPresent()) {
            return playerRepository.deletePlayerByName(name);
        }
        return -1L;
    }


}
