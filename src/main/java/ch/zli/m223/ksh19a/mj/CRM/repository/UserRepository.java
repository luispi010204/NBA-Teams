package ch.zli.m223.ksh19a.mj.CRM.repository;

import ch.zli.m223.ksh19a.mj.CRM.model.AppUser;
import ch.zli.m223.ksh19a.mj.CRM.model.AppUserImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUserImpl, Long> {


    default AppUser insert(String userName) {
        AppUserImpl user = new AppUserImpl(userName);
        return save(user);
    }

    Optional<AppUserImpl> findUserByName(String name);

    Long deleteByName(String name);
}
