package hackatlon_java.first_steps.Repositories;

import hackatlon_java.first_steps.Entities.ProfileUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileUserRepository extends CrudRepository<ProfileUser,Long> {
}
