package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19a.mj.CRM.exception.UserNotFoundException;
import ch.zli.m223.ksh19a.mj.CRM.model.AppUser;
import ch.zli.m223.ksh19a.mj.CRM.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<AppUser> getAllUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public AppUser getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException("There was no user with the id given.");
        });
    }

    @Override
    public AppUser insertUser(String name) {
        if (name == null) {
            throw new InvalidArgumentException("Name must no be null");
        } else {
            return userRepository.insert(name);
        }
    }


}
