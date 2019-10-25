package com.coding.challenge.repository;

import com.coding.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    @Query(
            value = "SELECT u.* FROM user_organization uo JOIN user u ON u.UserID=uo.UserID WHERE uo.OrganizationID=?1",
            nativeQuery = true
    )
    List<User> fetchUsersInOrganization(int id);

}
