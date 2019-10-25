package com.coding.challenge.service;

import com.coding.challenge.entity.Organization;
import com.coding.challenge.entity.User;

import java.util.List;

public interface OrganizationService {

    List<Organization> getAllOrganizations();

    List<Organization> getOrganizationsByUser(int id);

    void addOrganization(Organization organization);

}
