package com.gussoft.security.repository;

import com.gussoft.security.models.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findOneByEmail(String email);

}
