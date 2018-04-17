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
        User user = new User(userDTO.getUsername(), userDTO.getPassword());
        user.setUserId(userDTO.getUserId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        return user;
    }


    public static UserDTO makeUserDTO(User user)
    {
        UserDTO.UserDTOBuilder userDTOBuilder = UserDTO.newBuilder()
                .setUserId(user.getUserId())
                .setPassword(user.getPassword())
                .setUsername(user.getUsername())
                .setOnlineStatus(user.getOnlineStatus())
                .setDeleted(user.getDeleted())
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
