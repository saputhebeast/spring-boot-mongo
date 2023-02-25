package com.example.springmongo.repository;

import com.example.springmongo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    List<Person> findByFirstNameStartsWith(String name);
//    List<Person> findByAgeBetween(Integer min, Integer max);
//    query annotation
    @Query(value = "{'age': {$gt : ?0, $lt : ?1}}", fields = "{addresses:  0}")
    List<Person> findPersonByAgeBeween(Integer min, Integer max);
}
