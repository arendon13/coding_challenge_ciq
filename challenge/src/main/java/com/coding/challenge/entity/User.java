package com.coding.challenge.entity;

import com.coding.challenge.payload.UserRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="UserID")
    private int userID;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="Email")
    private String email;

    @Column(name="Address")
    private String address;

    @Column(name="Phone")
    private String phone;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_organization",
            joinColumns = @JoinColumn(name="UserID"),
            inverseJoinColumns = @JoinColumn(name="OrganizationID") )
    private Set<Organization> organizations = new HashSet<>();

    public User() {}

    public User(UserRequest userRequest) {

        this.firstName = userRequest.getFirstName();
        this.lastName = userRequest.getLastName();
        this.email = userRequest.getEmail();
        this.address = userRequest.getAddress();
        this.phone = userRequest.getPhone();

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }
}
