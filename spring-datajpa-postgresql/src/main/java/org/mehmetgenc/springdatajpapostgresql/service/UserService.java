package org.mehmetgenc.springdatajpapostgresql.service;

import org.mehmetgenc.springdatajpapostgresql.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDto save(UserDto userDto);
    void delete(Long id);
    UserDto getAll(UserDto userDto);

    Page<UserDto> getAll(Pageable pageable);
}
