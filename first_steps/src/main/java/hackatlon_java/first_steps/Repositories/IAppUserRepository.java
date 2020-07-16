package hackatlon_java.first_steps.Repositories;

import hackatlon_java.first_steps.Entities.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepository extends CrudRepository<AppUser,Long> {
}
