package hackatlon_java.first_steps.Repositories;

import hackatlon_java.first_steps.Entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IPostRepository extends CrudRepository<Post,Long> {
    Collection<Post> findTopByScore(int num);
}
