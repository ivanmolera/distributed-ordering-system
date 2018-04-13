package com.appchana.dos.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

/**
 * Created by ivanmolera on 13/04/2018.
 */
public class UserRacquetDTO {
    private Long userRacquetId;
    private String picture01;
    private String picture02;
    private String picture03;
    private UserDTO user;
    private RacquetDTO racquet;

    private UserRacquetDTO()
    {
    }


    public UserRacquetDTO(Long userRacquetId, UserDTO user, RacquetDTO racquet, String picture01, String picture02, String picture03)
    {
        this.userRacquetId = userRacquetId;
        this.user = user;
        this.racquet = racquet;
        this.picture01 = picture01;
        this.picture02 = picture02;
        this.picture03 = picture03;
    }


    public static UserRacquetDTOBuilder newBuilder()
    {
        return new UserRacquetDTOBuilder();
    }


    public Long getUserRacquetId()
    {
        return userRacquetId;
    }

    @JsonIgnore
    public UserDTO getUser()
    {
        return user;
    }

    @NotNull(message = "Racquet can not be null!")
    public RacquetDTO getRacquet()
    {
        return racquet;
    }

    public String getPicture01() {
        return picture01;
    }

    public String getPicture02() {
        return picture02;
    }

    public String getPicture03() {
        return picture03;
    }


    public static class UserRacquetDTOBuilder
    {
        private Long userRacquetId;
        private UserDTO user;
        private RacquetDTO racquet;
        private String picture01;
        private String picture02;
        private String picture03;


        public UserRacquetDTOBuilder setUserRacquetId(Long userRacquetId)
        {
            this.userRacquetId = userRacquetId;
            return this;
        }


        public UserRacquetDTOBuilder setUser(UserDTO user)
        {
            this.user = user;
            return this;
        }


        public UserRacquetDTOBuilder setRacquet(RacquetDTO racquet)
        {
            this.racquet = racquet;
            return this;
        }


        public UserRacquetDTOBuilder setPicture01(String picture01)
        {
            this.picture01 = picture01;
            return this;
        }


        public UserRacquetDTOBuilder setPicture02(String picture02)
        {
            this.picture02 = picture02;
            return this;
        }


        public UserRacquetDTOBuilder setPicture03(String picture03)
        {
            this.picture03 = picture03;
            return this;
        }


        public UserRacquetDTO createUserRacquetDTO()
        {
            return new UserRacquetDTO(userRacquetId, user, racquet, picture01, picture02, picture03);
        }

    }
}
