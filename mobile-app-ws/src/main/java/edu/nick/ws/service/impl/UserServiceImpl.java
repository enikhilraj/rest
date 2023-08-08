package edu.nick.ws.service.impl;

import edu.nick.ws.UserRepository;
import edu.nick.ws.io.entity.UserEntity;
import edu.nick.ws.service.UserService;
import edu.nick.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEncryptedPassword("encryptedPassword");
        userEntity.setUserId("userId");
        BeanUtils.copyProperties(user,  userEntity);

        UserEntity storedUserDetails = userRepository.save(userEntity);
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}
