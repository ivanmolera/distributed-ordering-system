package com.appchana.dos.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivanmolera on 12/04/2018.
 */
@Entity
@Table(name = "racquets")
public class Racquet
{
    private Long racquetId;
    private ZonedDateTime dateCreated = ZonedDateTime.now();
    private String mark;
    private String model;
    private String description;
    private String picture01;
    private String picture02;
    private String picture03;
    private Boolean deleted = false;

    private List<UserRacquet> userRacquets = new ArrayList<UserRacquet>();

    private Racquet()
    {
    }

    public Racquet(String mark, String model)
    {
        this.mark = mark;
        this.model = model;
        this.deleted = false;
    }

    @Id
    @GeneratedValue
    @Column(name = "racquet_id")
    public Long getRacquetId() { return racquetId; }
    public void setRacquetId(Long racquetId) { this.racquetId = racquetId; }

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
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }

    @Column(nullable = false)
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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

    @Column(nullable = false)
    public Boolean getDeleted() { return deleted; }
    public void setDeleted(Boolean deleted) { this.deleted = deleted; }

    @OneToMany(mappedBy = "racquet")
    public List<UserRacquet> getUserRacquets() {
        return userRacquets;
    }
    public void setUserRacquets(List<UserRacquet> userRacquets) {
        this.userRacquets = userRacquets;
    }
}
