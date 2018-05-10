package com.appchana.dos.dto;

import com.appchana.dos.controller.mapper.UserContactMapper;
import com.appchana.dos.dao.model.UserContact;
import com.appchana.dos.domainvalue.OnlineStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by ivanmolera on 12/04/2018.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @ApiModelProperty(value = "User unique identifier", dataType = "java.lang.Long", required=true)
    private Long userId;

    @ApiModelProperty(value = "Unique username (an email address)", dataType = "java.lang.String", required=true)
    private String username;

    @ApiModelProperty(value = "User password", dataType = "java.lang.String", required=true)
    private String password;

    @ApiModelProperty(value = "User name", dataType = "java.lang.String", required = false)
    private String name;

    @ApiModelProperty(value = "User surname", dataType = "java.lang.String", required = false)
    private String surname;

    @ApiModelProperty(value = "User status", dataType = "java.lang.String", allowableValues = "true,false", required = false)
    private Boolean deleted;

    @ApiModelProperty(value = "Online status", dataType = "com.appchana.dos.domainvalue.OnlineStatus", allowableValues = "ONLINE, OFFLINE", required = false)
    private OnlineStatus onlineStatus;

    @ApiModelProperty(value = "User contact details", required = true)
    private UserContactDTO contact;

    @ApiModelProperty(value = "User racquets", required = false)
    private List<Long> racquets;

    private UserDTO() {
    }


    private UserDTO(Long userId, String username, String password, String name, String surname, OnlineStatus onlineStatus, Boolean deleted, UserContactDTO contact, List<Long> racquets) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.deleted = deleted;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Boolean getDeleted() {
        return deleted;
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
        private String name;
        private String surname;
        private Boolean deleted;
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


        public UserDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }


        public UserDTOBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }


        public UserDTOBuilder setDeleted(Boolean deleted) {
            this.deleted = deleted;
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
            return new UserDTO(userId, username, password, name, surname, onlineStatus, deleted, contact, racquets);
        }

    }
}