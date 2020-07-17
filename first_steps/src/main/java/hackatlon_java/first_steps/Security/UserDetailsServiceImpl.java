package hackatlon_java.first_steps.Security;

import hackatlon_java.first_steps.Entities.AppUser;
import hackatlon_java.first_steps.Services.MasterService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("custom")
public class UserDetailsServiceImpl implements UserDetailsService {

    MasterService masterService;

    public UserDetailsServiceImpl(MasterService masterService) {
        this.masterService = masterService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser currentUser = masterService.getUserByName(username);
        if (currentUser != null) {
            return new User(currentUser.getName(), currentUser.getPassword(), new ArrayList<>());
        }
        throw new UsernameNotFoundException("user not found");
    }

    private CurrentUser buildUserForAuthentication(AppUser user, List<GrantedAuthority> authorities) {
        String username = user.getName();
        String password = user.getPassword();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Long id = user.getId();
        CurrentUser currentUser = new CurrentUser(username, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities);
        currentUser.setId(id);
        return currentUser;
    }
}