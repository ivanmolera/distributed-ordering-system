package com.appchana.dos.controller.mapper;

import com.appchana.dos.dao.model.User;
import com.appchana.dos.dto.UserDTO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ivanmolera on 13/04/2018.
 */
public class UserMapper
{
    public static User makeUser(UserDTO userDTO)
    {
        return new User(userDTO.getUsername(), userDTO.getPassword());
    }


    public static UserDTO makeUserDTO(User user)
    {
        UserDTO.UserDTOBuilder userDTOBuilder = UserDTO.newBuilder()
                .setUserId(user.getUserId())
                .setPassword(user.getPassword())
                .setUsername(user.getUsername())
                .setContact(user.getUserContact());

        return userDTOBuilder.createUserDTO();
    }


    public static List<UserDTO> makeUserDTOList(Collection<User> users)
    {
        return users.stream()
                .map(UserMapper::makeUserDTO)
                .collect(Collectors.toList());
    }
}
