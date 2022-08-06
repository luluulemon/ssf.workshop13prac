package com.visa.workshop13prac.Model;

import java.util.Random;

public class Contacts {
    private String name;
    private String email;
    private String phoneNumber;
    private String id;


    public Contacts(){
        generateId();
    }

// need to make it synchronized, id will be one after another
    public synchronized void generateId(){
        Random random = new Random();
        id = "";

        while(id.length() < 8)          
        {    id += Integer.toHexString(random.nextInt());    }
        
        id.substring(0,8);
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
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getId() {
        return id;
    }
    public void setId(String id){   this.id = id;   }


}
