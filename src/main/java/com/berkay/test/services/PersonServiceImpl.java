package com.berkay.test.services;

import com.berkay.test.entities.Person;
import com.berkay.test.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        try {
            personRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e) { //user zaten yok, db'den empty result gelmiş
            System.out.println("User "+id+" doesn't exist"); //istersek loglayabiliriz
        }
    }


    @Override
    public void save(Person person) {
        person.setName(person.getName().toUpperCase(Locale.ROOT));
        person.setLastName(person.getLastName());
        person.setAge(person.getAge());
    personRepository.save(person);
    }
}
