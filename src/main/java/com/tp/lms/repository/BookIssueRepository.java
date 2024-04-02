package com.tp.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tp.lms.model.BookIssue;

@Repository
public interface BookIssueRepository extends JpaRepository<BookIssue, Integer> {

}
