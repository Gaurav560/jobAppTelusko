package com.telusko.repo;

import com.telusko.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {
    /**
     * findByName method is used to retrieve a user by their username.
     * It returns an Optional of UserInfo, which will be empty if no user is found.
 
     */
    Optional<UserInfo> findByUserName(String userName);
}
