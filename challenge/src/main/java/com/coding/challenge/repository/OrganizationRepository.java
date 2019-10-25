package com.coding.challenge.repository;

import com.coding.challenge.entity.Organization;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrganizationRepository extends PagingAndSortingRepository<Organization ,Integer> {


}
