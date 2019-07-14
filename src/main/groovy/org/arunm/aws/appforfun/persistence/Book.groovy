package org.arunm.aws.appforfun.persistence

import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@EqualsAndHashCode
class Book {

    public Book() {
        super();
    }

    public Book(String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    @Column(nullable = false, unique = true)
    String title

    @Column(nullable = false)
    String author
}
