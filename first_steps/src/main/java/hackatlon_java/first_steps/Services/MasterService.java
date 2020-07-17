package hackatlon_java.first_steps.Services;

import hackatlon_java.first_steps.DTOs.CreateUserDTO;
import hackatlon_java.first_steps.Entities.AppUser;
import hackatlon_java.first_steps.Repositories.IAppUserRepository;
import hackatlon_java.first_steps.Repositories.IProfileUserRepository;
import org.springframework.stereotype.Service;

@Service
public class MasterService {

    private IAppUserRepository appUserRepository;
    private IProfileUserRepository profileUserRepository;

    public void createUser(CreateUserDTO userDTO){
        AppUser newUser = new AppUser(userDTO.name, userDTO.password, userDTO.email);
        appUserRepository.save(newUser);
    }

    public MasterService(IAppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    public AppUser getUserByName(String name){
        return appUserRepository.findByName(name).isPresent() ? appUserRepository.findByName(name).get() : null;
    }
}