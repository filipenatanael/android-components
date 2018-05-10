package com.project.fun.the.myapplication.model;

/**
 * Created by Filipe Natanael on 09/05/2018.
 */

class Contact {

    private int id;
    private String name;
    private String email;
    private String phonernumber;

    public Contact() {}


    public Contact(String name, String email, String phonernumber){
        super();
        this.name = name;
        this.email = email;
        this.phonernumber = phonernumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonernumber() {
        return phonernumber;
    }

    public void setPhonernumber(String phonernumber) {
        this.phonernumber = phonernumber;
    }
}
