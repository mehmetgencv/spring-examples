package org.mehmetgenc.springdatajpapostgresql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "user address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})

public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "address_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private Long id;
    @Column(name = "address", length = 500)
    private String address;
    @Enumerated
    private AddressType addressType;
    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "user_address_id")
    private User user;

    public enum AddressType {
        HOME,
        WORK,
        OTHER
    }
}
