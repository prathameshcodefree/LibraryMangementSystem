package com.tp.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tp.lms.response.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer> {

}
