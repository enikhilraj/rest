package edu.nick.ws.service;

import edu.nick.ws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    public UserDto createUser(UserDto user);
}
