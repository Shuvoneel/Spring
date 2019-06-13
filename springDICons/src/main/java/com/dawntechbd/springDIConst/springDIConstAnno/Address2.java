package com.dawntechbd.springDIConst.springDIConstAnno;

public class Address2 {
    private String city;
    private String state;
    private String country;

    public Address2(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String toString(){
        return city+" "+state+" "+country;
    }
}
