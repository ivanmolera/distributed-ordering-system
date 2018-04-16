package com.appchana.dos.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ivanmolera on 12/04/2018.
 */
@Entity
@Table(name = "contacts")
public class Contact {
    private Long contactId;
    private String country;
    private String region;
    private String city;
    private String postalCode;
    private String address;
    private String phone;

    private User user;

    public Contact() {
    }

    public Contact(String country, String region, String city, String postalCode, String address, String phone) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
        this.phone = phone;
    }

    @Id
    @GeneratedValue
    @Column(name = "contact_id")
    public Long getContactId() {
        return contactId;
    }
    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }


    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }


    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }


    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }


    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }


    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }


    //@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "user_id", nullable = false)
    //@NotNull(message = "UserId can not be null!")
    @JsonIgnore
    @OneToOne(mappedBy = "contact")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
