package hackatlon_java.first_steps.Repositories;

import hackatlon_java.first_steps.Entities.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface IQuestionRepository extends CrudRepository<Question, Long> {
    ArrayList<Question> findAllByID();
}
