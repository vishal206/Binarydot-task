/**
 Data from API is stored in this class.
 **/

package com.example.binarydottask.model;

public class users {
    private String firstName;
    private String secondName,email,id,image;

    public users(String firstName, String secondName, String email, String id, String image) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.id = id;
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
