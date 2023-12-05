package org.mehmetgenc.springdatajpapostgresql.repo;

import org.mehmetgenc.springdatajpapostgresql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
