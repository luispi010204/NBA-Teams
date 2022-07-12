package ch.zli.m223.ksh19a.mj.CRM.repository;


import ch.zli.m223.ksh19a.mj.CRM.model.AppUser;
import ch.zli.m223.ksh19a.mj.CRM.model.AppUserImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Role;
import ch.zli.m223.ksh19a.mj.CRM.model.RoleImpl;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<RoleImpl, Long> {

    default Role insert(String roleName, AppUser appUser) {
        AppUserImpl userImpl = (AppUserImpl) appUser;
        //Create new Role
        RoleImpl role = new RoleImpl(roleName, userImpl);
        //Save Role to DB
        RoleImpl roleImpl = save(role);
        // Update users role list
        userImpl.addRoleToList(roleImpl);

        return roleImpl;
    }
}