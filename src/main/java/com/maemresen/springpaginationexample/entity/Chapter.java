package com.maemresen.springpaginationexample.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private boolean read;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @ToString.Exclude
    @JsonBackReference
    private Book book;
}
