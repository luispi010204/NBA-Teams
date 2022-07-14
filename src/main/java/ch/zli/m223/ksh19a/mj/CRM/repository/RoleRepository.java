package ch.zli.m223.ksh19a.mj.CRM.repository;


import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.PlayerImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Role.Role;
import ch.zli.m223.ksh19a.mj.CRM.model.Role.RoleImpl;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<RoleImpl, Long> {

    default Role insert(String roleName, Player player) {
        PlayerImpl playerImpl = (PlayerImpl) player;
        //Create new Role
        RoleImpl role = new RoleImpl(roleName, playerImpl);
        //Save Role to DB
        RoleImpl roleImpl = save(role);
        // Update users role list
        playerImpl.addRoleToList(roleImpl);

        return roleImpl;
    }
}