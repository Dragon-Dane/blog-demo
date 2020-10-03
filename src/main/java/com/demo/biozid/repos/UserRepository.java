package com.demo.biozid.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.biozid.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository< User, Long > {
    User findByEmail(String email);
}