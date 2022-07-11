package ch.zli.m223.ksh19a.mj.CRM.repository;

import ch.zli.m223.ksh19a.mj.CRM.model.AppUser;
import ch.zli.m223.ksh19a.mj.CRM.model.AppUserImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUserImpl, Long> {


    default AppUser insert(String userName) {
        AppUserImpl user = new AppUserImpl(userName);
        return save(user);
    }
}
