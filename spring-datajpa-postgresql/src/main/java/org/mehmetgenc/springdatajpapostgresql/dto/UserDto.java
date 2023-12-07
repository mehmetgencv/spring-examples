package org.mehmetgenc.springdatajpapostgresql.dto;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.mehmetgenc.springdatajpapostgresql.entity.Address;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class UserDto {
    private Long id;
    @NotNull
    private String name;
    private String surname;
    private List<String> addresses;
}
