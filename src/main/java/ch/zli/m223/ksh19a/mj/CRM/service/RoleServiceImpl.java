package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19a.mj.CRM.exception.UserAlreadyExistsException;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.model.Role.Role;
import ch.zli.m223.ksh19a.mj.CRM.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    private Player player;

    @Override
    public List<Role> getAllRoles() {
        return new ArrayList<>(roleRepository.findAll());
    }

    @Override
    public Role getRole(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Invalid user Id " + id);
        });
    }

    @Override
    public Role insertRole(String role) {
        if (role == null)
            throw new InvalidArgumentException("Name must not be null");
        if (roleRepository.findRoleByName(role).isPresent()) {
            throw new UserAlreadyExistsException("Role with name" + role + " already exists");
        }
        return roleRepository.insert(role, player);
    }

    @Override
    public void deleteRoleById(Long id) {
        if (id == null)
            throw new InvalidArgumentException("Id must not be null");
        if (roleRepository.findById(id).isEmpty()) {
            return;
        }
        roleRepository.deleteById(id);
    }

}
