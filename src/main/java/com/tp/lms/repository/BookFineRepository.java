package com.tp.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tp.lms.model.BookFine;

@Repository
public interface BookFineRepository extends JpaRepository<BookFine, Integer> {

}
