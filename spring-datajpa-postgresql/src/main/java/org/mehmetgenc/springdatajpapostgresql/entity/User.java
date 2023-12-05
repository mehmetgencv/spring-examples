package org.mehmetgenc.springdatajpapostgresql.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class User {

    @jakarta.persistence.Id
    @Id
    @SequenceGenerator(name = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "surname", length = 50)
    private String surname;
    @OneToMany
    @JoinColumn(name = "user_address_id")
    private List<Address> addresses;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
