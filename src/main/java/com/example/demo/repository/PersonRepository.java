package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jjmendoza on 31/8/2018.
 */
@Repository
public interface PersonRepository extends CrudRepository <Person, Long>{
}
