package com.berkay.test.services;

import com.berkay.test.entities.Person;

import java.util.List;

public interface IPersonService {
    List<Person> getAllPerson();
    void save(Person person);
    Person getPersonById(Long id);

}
