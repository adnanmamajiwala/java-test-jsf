package org.javatest.springbootjsf.repositories;

import org.javatest.springbootjsf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
