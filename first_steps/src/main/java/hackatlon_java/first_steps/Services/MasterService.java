package hackatlon_java.first_steps.Services;

import hackatlon_java.first_steps.DTOs.CreateUserDTO;
import hackatlon_java.first_steps.Entities.AppUser;
import hackatlon_java.first_steps.Entities.Post;
import hackatlon_java.first_steps.Entities.ProfileUser;
import hackatlon_java.first_steps.Repositories.IAppUserRepository;
import hackatlon_java.first_steps.Repositories.IPostRepository;
import hackatlon_java.first_steps.Repositories.IProfileUserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MasterService {

    private IAppUserRepository appUserRepository;
    private IProfileUserRepository profileUserRepository;
    private IPostRepository iPostRepository;


    public void createUser(CreateUserDTO userDTO){
        AppUser newUser = new AppUser(userDTO.name, userDTO.password, userDTO.email);
        appUserRepository.save(newUser);
    }

    public Optional<AppUser> findUser (long id){
        return appUserRepository.findById(id);
    }
    public void countPoint(int point, Optional<AppUser> id){
        ProfileUser pu = profileUserRepository.findByAppUser(id);
        pu.setTestResult(pu.getTestResult()+point);
        profileUserRepository.save(pu);
    }

    public MasterService(IAppUserRepository appUserRepository,IPostRepository iPostRepository){
        this.appUserRepository = appUserRepository;
        this.iPostRepository=iPostRepository;
    }

    public AppUser getUserByName(String name){
        return appUserRepository.findByName(name).isPresent() ? appUserRepository.findByName(name).get() : null;
    }
    public void savePost(String post, String name) {
        iPostRepository.save(new Post(post, name));
    }
    public Collection<Post> getPosts() {
        return iPostRepository.findTopByScore(10);
    }

}