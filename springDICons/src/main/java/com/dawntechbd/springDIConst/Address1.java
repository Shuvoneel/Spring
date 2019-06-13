package com.dawntechbd.springDIConst;

public class Address1 {
        private String city;
        private String state;
        private String country;

        public Address1(String city, String state, String country) {
            super();
            this.city = city;
            this.state = state;
            this.country = country;
        }

        public String toString(){
            return city+" "+state+" "+country;
        }
}
