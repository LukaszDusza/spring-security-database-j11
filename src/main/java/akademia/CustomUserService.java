package akademia;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserService implements UserDetailsService {

  private final UserAppRepository userAppRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  public CustomUserService(UserAppRepository userAppRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
    this.userAppRepository = userAppRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    Optional<UserApp> optionalUserApp = userAppRepository.findUserByLogin(login);
    optionalUserApp.orElseThrow(() -> new UsernameNotFoundException("User: " + login + " not found!"));
    return optionalUserApp.map(CustomUserDetails::new).get();
  }
}
