package edu.nick.ws.service.impl;

import edu.nick.ws.UserRepository;
import edu.nick.ws.io.entity.UserEntity;
import edu.nick.ws.service.UserService;
import edu.nick.ws.shared.Utils;
import edu.nick.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) {

        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("User record already exists!");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,  userEntity);

        //userEntity.setEncryptedPassword("encryptedPassword");
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //userEntity.setUserId("userId");

        String publicUserId = utils.generateUserId(30);
        userEntity.setUserId(publicUserId);

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
