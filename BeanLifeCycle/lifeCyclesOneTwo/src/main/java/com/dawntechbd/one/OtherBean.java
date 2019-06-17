package com.dawntechbd.one;

public class OtherBean {
    private int id;
    private String depName;

    public void setId(int id) {

        this.id = id;
    }

    public void setDepName(String depName) {

        this.depName = depName;
    }

    public String getDepName() {

        return depName;
    }

    @Override
    public String toString() {
        return "OtherBean{" +
                "id =" + id +
                ", depName ='" + depName + '\'' +
                '}';
    }
}
