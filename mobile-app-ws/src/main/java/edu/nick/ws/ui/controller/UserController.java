package edu.nick.ws.ui.controller;

import edu.nick.ws.service.UserService;
import edu.nick.ws.shared.dto.UserDto;
import edu.nick.ws.ui.model.request.UserDetailsRequestModel;
import edu.nick.ws.ui.model.response.UserDetailsResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String getUser() {
		return "getUser was called.";
	}
	
	@PostMapping
	public UserDetailsResponseModel createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto createdUser = userService.createUser(userDto);
		UserDetailsResponseModel returnValue = new UserDetailsResponseModel();
		BeanUtils.copyProperties(createdUser, returnValue);

		return returnValue;
	}

	@PutMapping
	public String updateUser() {
		return "updateUser was called.";
	}

	@DeleteMapping
	public String deleteUser() {
		return "deleteUser was called.";
	}

}
