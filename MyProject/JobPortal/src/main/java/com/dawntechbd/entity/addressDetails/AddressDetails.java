package com.dawntechbd.entity.addressDetails;

import com.dawntechbd.entity.User;

import javax.persistence.*;

@Entity
@Table
public class AddressDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String addressType;
    private String village;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private int postcode;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public AddressDetails() {
    }

    public AddressDetails(String addressType, String village, City city, int postcode, User user) {
        this.addressType = addressType;
        this.village = village;
        this.city = city;
        this.postcode = postcode;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
