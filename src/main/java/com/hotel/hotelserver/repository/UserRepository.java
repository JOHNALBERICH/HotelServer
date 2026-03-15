package com.hotel.hotelserver.repository;

import com.hotel.hotelserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User>findByEmail(String userEmail);
    boolean existedByEmail(String userEmail);
    boolean existedByUsername(String userName);

}
