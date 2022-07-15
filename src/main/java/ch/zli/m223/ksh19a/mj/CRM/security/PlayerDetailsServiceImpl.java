package ch.zli.m223.ksh19a.mj.CRM.security;

import ch.zli.m223.ksh19a.mj.CRM.exception.NotFoundException;
import ch.zli.m223.ksh19a.mj.CRM.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PlayerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PlayerRepository playerRepository;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return playerRepository.findPlayerByName(name).orElseThrow(() -> {
            throw new NotFoundException(name);
        });

    }
}
