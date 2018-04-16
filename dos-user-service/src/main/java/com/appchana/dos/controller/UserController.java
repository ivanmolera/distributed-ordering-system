package com.appchana.dos.controller;

import com.appchana.dos.controller.mapper.ContactMapper;
import com.appchana.dos.controller.mapper.UserMapper;
import com.appchana.dos.controller.mapper.UserRacquetMapper;
import com.appchana.dos.dao.model.User;
import com.appchana.dos.domainvalue.OnlineStatus;
import com.appchana.dos.dto.ContactDTO;
import com.appchana.dos.dto.UserDTO;
import com.appchana.dos.dto.UserRacquetDTO;
import com.appchana.dos.exception.ConstraintsViolationException;
import com.appchana.dos.exception.EntityNotFoundException;
import com.appchana.dos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ivanmolera on 12/04/2018.
 */
@RestController
@RequestMapping("v1/users")
public class UserController
{

    protected final UserService userService;


    @Autowired
    public UserController(final UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserDTO getUser(@Valid @PathVariable long userId) throws EntityNotFoundException
    {
        return UserMapper.makeUserDTO(userService.find(userId));
    }

    @GetMapping("/{userId}/racquets")
    public List<UserRacquetDTO> getUserRacquets(@Valid @PathVariable long userId) throws EntityNotFoundException
    {
        User user = userService.find(userId);
        return UserRacquetMapper.makeUserRacquetDTOList(user.getUserRacquets());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) throws ConstraintsViolationException
    {
        User user = UserMapper.makeUser(userDTO);
        user.setContact(ContactMapper.makeContact(userDTO.getContact()));
        return UserMapper.makeUserDTO(userService.create(user));
    }


    @DeleteMapping("/{userId}")
    public void deleteUser(@Valid @PathVariable long userId) throws EntityNotFoundException
    {
        userService.delete(userId);
    }


    @GetMapping
    public List<UserDTO> findUsers(@RequestParam OnlineStatus onlineStatus)
            throws ConstraintsViolationException, EntityNotFoundException
    {
        return UserMapper.makeUserDTOList(userService.find(onlineStatus));
    }
}
