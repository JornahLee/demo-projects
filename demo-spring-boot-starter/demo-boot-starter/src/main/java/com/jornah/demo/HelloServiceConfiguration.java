package com.jornah.demo;

public class HelloServiceConfiguration {

    private String name;

    private String hobby;

    public String getName() {
        return "name is " + name;
    }

    public String getHobby() {
        return "hobby is " + hobby;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "HelloServiceConfiguration{" +
                "name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
