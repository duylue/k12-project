package com.student.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cusId")
    private Customer customer;

}
