package com.otmbidirectional.otmBiderectional.repository;

import com.otmbidirectional.otmBiderectional.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
