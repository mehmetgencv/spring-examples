package org.mehmetgenc.springdatajpapostgresql.dto;

import lombok.Data;
import org.mehmetgenc.springdatajpapostgresql.entity.Address;

import java.util.List;
@Data
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private List<String> addresses;
}
