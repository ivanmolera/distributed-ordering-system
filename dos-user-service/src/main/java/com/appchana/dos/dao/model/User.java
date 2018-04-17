package com.appchana.dos.dao.model;

import com.appchana.dos.domainvalue.OnlineStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivanmolera on 12/04/2018.
 */
@Entity
@Table(
        name = "users",
        uniqueConstraints = @UniqueConstraint(name = "uc_users_username", columnNames = {"username"})
)
public class User
{
    private Long userId;
    private ZonedDateTime dateCreated = ZonedDateTime.now();
    private String username;
    private String password;
    private String name;
    private String surname;
    private Boolean deleted = false;
    private OnlineStatus onlineStatus;

    @OneToOne()
    private UserContact userContact;

    private List<UserRacquet> userRacquets = new ArrayList<UserRacquet>();

    private User()
    {
    }

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.deleted = false;
        this.onlineStatus = OnlineStatus.OFFLINE;
    }

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }


    @JsonIgnore
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(nullable = false)
    @NotNull(message = "Username can not be null!")
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    @NotNull(message = "Password can not be null!")
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password) { this.password = password; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(nullable = false)
    public Boolean getDeleted()
    {
        return deleted;
    }
    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public OnlineStatus getOnlineStatus()
    {
        return onlineStatus;
    }
    public void setOnlineStatus(OnlineStatus onlineStatus)
    {
        this.onlineStatus = onlineStatus;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_contact_id")
    public UserContact getUserContact() {
        return userContact;
    }
    public void setUserContact(UserContact userContact) {
        this.userContact = userContact;
    }

    @OneToMany(mappedBy = "user")
    public List<UserRacquet> getUserRacquets() {
        return userRacquets;
    }
    public void setUserRacquets(List<UserRacquet> userRacquets) {
        this.userRacquets = userRacquets;
    }
}