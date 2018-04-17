package com.appchana.dos.dto;

import com.appchana.dos.controller.mapper.UserContactMapper;
import com.appchana.dos.dao.model.UserContact;
import com.appchana.dos.domainvalue.OnlineStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by ivanmolera on 12/04/2018.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Long userId;
    private String username;
    private String password;
    private OnlineStatus onlineStatus;
    private UserContactDTO contact;

    private List<Long> racquets;

    private UserDTO() {
    }


    private UserDTO(Long userId, String username, String password, OnlineStatus onlineStatus, UserContactDTO contact, List<Long> racquets) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.onlineStatus = onlineStatus;
        this.contact = contact;
        this.racquets = racquets;
    }


    public static UserDTOBuilder newBuilder() {
        return new UserDTOBuilder();
    }


    public Long getUserId() {
        return userId;
    }

    @NotNull(message = "Username can not be null!")
    public String getUsername() {
        return username;
    }

    //@JsonIgnore
    @NotNull(message = "Password can not be null!")
    public String getPassword() {
        return password;
    }

    public OnlineStatus getOnlineStatus() {
        return onlineStatus;
    }

    public UserContactDTO getContact() {
        return contact;
    }

    public List<Long> getRacquets() {
        return racquets;
    }

    public static class UserDTOBuilder {
        private Long userId;
        private String username;
        private String password;
        private OnlineStatus onlineStatus;
        private UserContactDTO contact;
        private List<Long> racquets;


        public UserDTOBuilder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }


        public UserDTOBuilder setUsername(String username) {
            this.username = username;
            return this;
        }


        public UserDTOBuilder setPassword(String password) {
            this.password = password;
            return this;
        }


        public UserDTOBuilder setOnlineStatus(OnlineStatus onlineStatus) {
            this.onlineStatus = onlineStatus;
            return this;
        }


        public UserDTOBuilder setContact(UserContact contact) {
            this.contact = UserContactMapper.makeContactDTO(contact);
            return this;
        }


        public UserDTOBuilder setRacquets(List<Long> racquets) {
            this.racquets = racquets;
            return this;
        }


        public UserDTO createUserDTO() {
            return new UserDTO(userId, username, password, onlineStatus, contact, racquets);
        }

    }
}