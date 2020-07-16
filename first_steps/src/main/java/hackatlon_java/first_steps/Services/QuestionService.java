package hackatlon_java.first_steps.Services;

import hackatlon_java.first_steps.DTOs.QuestionDTO;
import hackatlon_java.first_steps.Entities.Question;
import hackatlon_java.first_steps.Repositories.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class QuestionService {
    @Autowired
    IQuestionRepository questionRepository;

    public ArrayList<QuestionDTO> getQuestion(){

        ArrayList<Question> q = questionRepository.findAllByID();
        ArrayList<QuestionDTO> result = new ArrayList<QuestionDTO>();
        for (var item:q
             ) {
            result.add(new QuestionDTO(item.getQuestion(),item.getDescription(),item.getTitle(), item.getUrl()));
        }
    return  result;
    }
}
