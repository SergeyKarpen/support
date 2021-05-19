package com.omertex.support.repository;

import com.omertex.support.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);

    boolean existsUserById(Long aLong);


}
