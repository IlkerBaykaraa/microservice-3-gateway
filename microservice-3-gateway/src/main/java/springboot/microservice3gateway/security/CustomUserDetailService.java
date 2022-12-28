package springboot.microservice3gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springboot.microservice3gateway.model.User;
import springboot.microservice3gateway.service.IUserService;

@Service
public class CustomUserDetailService implements UserDetailsService
{

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userService.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found this username:"+ username));

        return new UserPrincipal(user.getId(), user.getUserName(),user.getPassword());
    }
}
