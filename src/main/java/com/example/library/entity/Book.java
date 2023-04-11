package com.example.library.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Buhishta Xwendine Books")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;
    @Column(name = "BOOK_NAME")
    String bookName;
    @Column(name = "BOOK_AUTHOR")
    String booksAuthor;
    @Column(name = "BOOK_PUBLISHER")
    String booksPublisher;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "RELEASE_DATE")
    String releaseDate;
    @Column(name = "ADD_DATE")
    String addDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IMAGE_ID")
    Images image;
}
