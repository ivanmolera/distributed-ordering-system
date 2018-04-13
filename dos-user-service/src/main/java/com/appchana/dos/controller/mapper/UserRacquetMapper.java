package com.appchana.dos.controller.mapper;

import com.appchana.dos.dao.model.UserRacquet;
import com.appchana.dos.dto.UserRacquetDTO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ivanmolera on 13/04/2018.
 */
public class UserRacquetMapper {
    public static UserRacquet makeUserRacquet(UserRacquetDTO userRacquetDTO)
    {
        return new UserRacquet(userRacquetDTO.getPicture01(), userRacquetDTO.getPicture02(), userRacquetDTO.getPicture03());
    }

    public static UserRacquetDTO makeUserRacquetDTO(UserRacquet userRacquet)
    {
        UserRacquetDTO.UserRacquetDTOBuilder userRacquetDTOBuilder = UserRacquetDTO.newBuilder()
                .setUserRacquetId(userRacquet.getUserRacquetId())
                .setUser(UserMapper.makeUserDTO(userRacquet.getUser()))
                .setRacquet(RacquetMapper.makeRacquetDTO(userRacquet.getRacquet()))
                .setPicture01(userRacquet.getPicture01())
                .setPicture02(userRacquet.getPicture02())
                .setPicture03(userRacquet.getPicture03());

        return userRacquetDTOBuilder.createUserRacquetDTO();
    }


    public static List<UserRacquetDTO> makeUserRacquetDTOList(Collection<UserRacquet> userRacquets)
    {
        return userRacquets.stream()
                .map(UserRacquetMapper::makeUserRacquetDTO)
                .collect(Collectors.toList());
    }
}
