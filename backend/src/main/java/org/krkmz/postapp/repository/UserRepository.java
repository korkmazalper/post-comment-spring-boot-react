package org.krkmz.postapp.repository;

import org.krkmz.postapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
