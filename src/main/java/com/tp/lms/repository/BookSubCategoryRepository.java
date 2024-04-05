package com.tp.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.lms.model.Book;

@Repository
public interface BookSubCategoryRepository extends JpaRepository<Book,Integer> {

}
