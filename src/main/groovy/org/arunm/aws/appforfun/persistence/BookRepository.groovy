package org.arunm.aws.appforfun.persistence

import org.springframework.data.repository.CrudRepository

interface BookRepository extends CrudRepository<Book, Long>{

    List<Book> findByTitle(String title);
}