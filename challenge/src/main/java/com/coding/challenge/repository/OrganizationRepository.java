package com.coding.challenge.repository;

import com.coding.challenge.entity.Organization;
import com.coding.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OrganizationRepository extends PagingAndSortingRepository<Organization ,Integer> {

    @Query(
            value = "SELECT o.* FROM user_organization uo JOIN organization o ON o.OrganizationID=uo.OrganizationID WHERE uo.UserID=?1",
            nativeQuery = true
    )
    List<Organization> fetchOrganizationsByUser(int id);

}
