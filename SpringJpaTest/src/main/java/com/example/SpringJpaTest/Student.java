package com.example.SpringJpaTest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity(name = "Student")
@Getter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(
            name = "bio",
            columnDefinition = "TEXT"
    )
    private String bio;

    public Student(String firstName, String lastName, String email, Integer age, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.bio = bio;
    }

    public Student() {
    }
}
