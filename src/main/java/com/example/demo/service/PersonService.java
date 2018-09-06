package com.example.demo.service;

import com.example.demo.model.Contact;
import com.example.demo.model.Person;

/**
 * Created by jjmendoza on 6/9/2018.
 */
public interface PersonService {
    Person createPerson();
    Person savePerson(Person person);
    void addContact(Person person);
    void removeContact(Person person, Integer contactIndex);
}
