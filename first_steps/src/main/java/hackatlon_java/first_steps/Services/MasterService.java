package hackatlon_java.first_steps.Services;

import hackatlon_java.first_steps.DTOs.CreateUserDTO;
import hackatlon_java.first_steps.Entities.AppUser;
import hackatlon_java.first_steps.Repositories.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterService {

    private IAppUserRepository appUserRepository;

    public void createUser(CreateUserDTO userDTO){
        AppUser newUser = new AppUser(userDTO.getName(), userDTO.getPassword(), userDTO.getEmail());
        appUserRepository.save(newUser);
    }

    public MasterService(IAppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

}
