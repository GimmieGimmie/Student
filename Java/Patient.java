package com.jdbclearning.entities;

public class Patient {

    private int id;
    private String name;
    private String concern;
    private String address;
    private String blood;

    public Patient(String name, String concern, String address, String blood) {
        this.name = name;
        this.concern = concern;
        this.address = address;
        this.blood = blood;
    }

    public Patient() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConcern() {
        return concern;
    }

    public void setConcern(String concern) {
        this.concern = concern;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {

        return "Patient: |" +
                "id: " + id +
                "|name: '" + name + '\'' +
                "|concern: '" + concern + '\'' +
                "|address: '" + address + '\'' +
                "|blood: '" + blood + '\'' +
                '|';
    }

}
