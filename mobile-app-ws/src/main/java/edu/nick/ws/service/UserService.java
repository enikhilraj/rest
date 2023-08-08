package edu.nick.ws.service;

import edu.nick.ws.shared.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserDto createUser(UserDto user);
}
