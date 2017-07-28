package com.officemanagement.repository;


import com.officemanagement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Abdurahman on 7/27/2017.
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}
