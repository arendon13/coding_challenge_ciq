package com.coding.challenge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@IdClass(UserOrganization.class)
@Table(name="user_organization")
public class UserOrganization implements Serializable {

    @NotNull
    @Id
    @Column(name="UserID")
    private int userID;

    @NotNull
    @Id
    @Column(name="OrganizationID")
    private int organizationID;

    public UserOrganization() {}

    public UserOrganization(int userID, int organizationID) {

        this.userID = userID;
        this.organizationID = organizationID;

    }

    public int getUserID() {
        return userID;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    @Override
    public String toString() {
        return "UserOrganization{" +
                "userID=" + userID +
                ", organizationID=" + organizationID +
                '}';
    }
}
