package com.appchana.dos.controller;

import com.appchana.dos.controller.mapper.UserContactMapper;
import com.appchana.dos.controller.mapper.UserMapper;
import com.appchana.dos.controller.mapper.UserRacquetMapper;
import com.appchana.dos.dao.model.User;
import com.appchana.dos.domainvalue.OnlineStatus;
import com.appchana.dos.dto.UserDTO;
import com.appchana.dos.dto.UserRacquetDTO;
import com.appchana.dos.exception.ConstraintsViolationException;
import com.appchana.dos.exception.EntityNotFoundException;
import com.appchana.dos.exception.ForbiddenException;
import com.appchana.dos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by ivanmolera on 12/04/2018.
 */
@RestController
@RequestMapping("v1/users")
public class UserController
{
    @Autowired
    protected final UserService userService;

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
    @Transactional
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) throws ConstraintsViolationException
    {
        User user = UserMapper.makeUser(userDTO);
        user.setUserContact(UserContactMapper.makeContact(userDTO.getContact()));
        return UserMapper.makeUserDTO(userService.create(user));
    }

    @PutMapping
    public UserDTO updateUser(@Valid @RequestBody UserDTO userDTO) throws EntityNotFoundException, ConstraintsViolationException
    {
        User user = UserMapper.makeUser(userDTO);
        user.setUserContact(UserContactMapper.makeContact(userDTO.getContact()));
        return UserMapper.makeUserDTO(userService.update(user));
    }

    @PutMapping("/updatepassword/{userId}")
    public void updatePassword(@Valid @PathVariable long userId, @RequestParam String oldPassword, @RequestParam String newPassword) throws EntityNotFoundException, ForbiddenException, ConstraintsViolationException
    {
        userService.updatePassword(userId, oldPassword, newPassword);
    }

    @GetMapping("activate/{userId}")
    public void activateUser(@Valid @PathVariable long userId) throws EntityNotFoundException
    {
        userService.activate(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@Valid @PathVariable long userId) throws EntityNotFoundException
    {
        userService.delete(userId);
    }

    @GetMapping
    public List<UserDTO> findUsers(@RequestParam OnlineStatus onlineStatus, @RequestParam Boolean deleted) throws ConstraintsViolationException, EntityNotFoundException
    {
        return UserMapper.makeUserDTOList(userService.find(onlineStatus, deleted));
    }
}
