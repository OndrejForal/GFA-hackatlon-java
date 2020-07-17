package hackatlon_java.first_steps.Repositories;

import hackatlon_java.first_steps.Entities.AppUser;
import hackatlon_java.first_steps.Entities.ProfileUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfileUserRepository extends CrudRepository<ProfileUser,Long> {

    ProfileUser findByAppUser(Optional<AppUser> appUser);
}
