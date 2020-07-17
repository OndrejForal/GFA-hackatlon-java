package hackatlon_java.first_steps.Controllers;

import hackatlon_java.first_steps.Security.CurrentUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class BaseController {
    public Long getUserId() {
        CurrentUser user = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.equals(null) ? null : user.getId();
    }
}