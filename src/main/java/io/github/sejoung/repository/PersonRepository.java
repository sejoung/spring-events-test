package io.github.sejoung.repository;

import org.springframework.data.repository.CrudRepository;

import io.github.sejoung.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
