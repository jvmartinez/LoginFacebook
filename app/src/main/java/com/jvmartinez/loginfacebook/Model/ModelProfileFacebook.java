package com.jvmartinez.loginfacebook.Model;

/*
 * Created by Juan Martinez on 9/2/18.
 */

public class ModelProfileFacebook {
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String completeName;
    private String token;
    private String id;

    public ModelProfileFacebook() {
    }

    public ModelProfileFacebook(String name, String lastName, String email, String phone, String completeName, String token, String id) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.completeName = completeName;
        this.token = token;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        completeName = completeName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
