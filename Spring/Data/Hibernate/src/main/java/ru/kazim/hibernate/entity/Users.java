package ru.kazim.hibernate.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name="id")
    @SequenceGenerator(initialValue=1, name="users_sequence", sequenceName="users_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_sequence")
    private int id;
    private String num1;
    private String num2;
}
