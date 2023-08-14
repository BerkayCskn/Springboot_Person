package com.berkay.test.services;

import com.berkay.test.entities.Person;
import com.berkay.test.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class PersonServiceImpl implements IPersonService{
    @Autowired
    private IPersonRepository personRepository;
    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }


    @Override
    public void save(Person person) {
        person.setName(person.getName().toUpperCase(Locale.ROOT));
        person.setLastName(person.getLastName());
        person.setAge(person.getAge());
    personRepository.save(person);
    }
}
