package com.dawntechbd.springDIConst;

public class Employee1 {
        private int id;
        private String name;
        private Address1 address1;

        public Employee1() {System.out.println("def cons");}

        public Employee1(int id) {this.id = id;}

        public Employee1(String name) {	this.name = name;}

        public Employee1(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Employee1(int id, String name, Address1 address1) {
            super();
            this.id = id;
            this.name = name;
            this.address1 = address1;
        }

        void show(){
            System.out.println(id+" "+name);
            System.out.println(address1.toString());
        }

}
