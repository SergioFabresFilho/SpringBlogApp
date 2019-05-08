package br.com.sergio.blog.ui.controller;

import br.com.sergio.blog.service.UserService;
import br.com.sergio.blog.shared.dto.UserDTO;
import br.com.sergio.blog.ui.model.request.UserDetailsRequestModel;
import br.com.sergio.blog.ui.model.response.OperationStatusModel;
import br.com.sergio.blog.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/{id}")
    public UserRest getUser(@PathVariable String id) {
        UserRest returnValue = new UserRest();

        UserDTO userDTO = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDTO, returnValue);

        return returnValue;
    }

    @PostMapping
    public UserRest createUser(@RequestBody @Valid UserDetailsRequestModel requestModel) throws RuntimeException {
        UserRest returnValue = new UserRest();

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(requestModel, userDTO);

        UserDTO createdUser = userService.createUser(userDTO);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
