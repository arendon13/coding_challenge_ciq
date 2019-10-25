package com.coding.challenge.service;

import com.coding.challenge.entity.Organization;
import com.coding.challenge.entity.User;
import com.coding.challenge.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<Organization> getAllOrganizations() {

        List<Organization> organizations = new ArrayList<>();
        organizationRepository.findAll().forEach( organizations::add );

        return organizations;

    }

    @Override
    public void addOrganization(Organization organization) {

        organizationRepository.save(organization);

    }

    @Override
    public List<Organization> getOrganizationsByUser(int id) {
        return organizationRepository.fetchOrganizationsByUser(id);
    }
}
