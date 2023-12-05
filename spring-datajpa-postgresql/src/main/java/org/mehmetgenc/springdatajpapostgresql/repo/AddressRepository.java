package org.mehmetgenc.springdatajpapostgresql.repo;

import org.mehmetgenc.springdatajpapostgresql.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
