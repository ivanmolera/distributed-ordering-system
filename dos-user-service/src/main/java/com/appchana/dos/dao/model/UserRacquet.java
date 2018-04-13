package com.appchana.dos.dao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

/**
 * Created by ivanmolera on 12/04/2018.
 */
@Entity
@Table(name = "users_racquets")
public class UserRacquet {

    private Long userRacquetId;
    private ZonedDateTime dateCreated = ZonedDateTime.now();
    private Boolean deleted = false;
    private String picture01;
    private String picture02;
    private String picture03;

    private User user;
    private Racquet racquet;


    private UserRacquet() {
    }

    public UserRacquet(String picture01, String picture02, String picture03) {
        this.picture01 = picture01;
        this.picture02 = picture02;
        this.picture03 = picture03;
    }

    @Id
    @GeneratedValue
    @Column(name = "user_racquet_id")
    public Long getUserRacquetId() { return userRacquetId; }

    public void setUserRacquetId(Long userRacquetId) { this.userRacquetId = userRacquetId; }


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }


    @Column(nullable = false)
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getPicture01() {
        return picture01;
    }

    public void setPicture01(String picture01) {
        this.picture01 = picture01;
    }


    public String getPicture02() {
        return picture02;
    }

    public void setPicture02(String picture02) {
        this.picture02 = picture02;
    }


    public String getPicture03() {
        return picture03;
    }

    public void setPicture03(String picture03) {
        this.picture03 = picture03;
    }


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "UserId can not be null!")
    @JsonIgnore
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "racquet_id", nullable = false)
    @NotNull(message = "RacquetId can not be null!")
    @JsonIgnore
    public Racquet getRacquet() {
        return racquet;
    }

    public void setRacquet(Racquet racquet) {
        this.racquet = racquet;
    }
}
