package com.jdbchibernatesql.securityregistrationauth.Repository;

import com.jdbchibernatesql.securityregistrationauth.Entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByUsername(String username);

}
