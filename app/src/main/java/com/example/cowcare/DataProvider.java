package com.example.cowcare;

public class DataProvider {
    private String name;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public DataProvider(String name, String number){
        this.name=name;
        this.number=number;
    }
}