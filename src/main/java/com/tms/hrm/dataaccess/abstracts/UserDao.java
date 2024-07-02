package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUserEmail(String email);

    User findById(int id);
}
