package com.tp.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tp.lms.model.Feedback;
@Repository
public interface FeedBackRespository extends CrudRepository<Feedback,Integer> {

}
