package com.coding.challenge.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="organization")
public class Organization {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="OrganizationID")
    private int organizationID;

    @Column(name="Name")
    private String name;

    @Column(name="Address")
    private String address;

    @Column(name="Phone")
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_organization",
                joinColumns = @JoinColumn(name="OrganizationID"),
                inverseJoinColumns = @JoinColumn(name="UserID") )
    private Set<User> users = new HashSet<>();

    public Organization() {}

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<User> getUsers() {
        return users;
    }
}
