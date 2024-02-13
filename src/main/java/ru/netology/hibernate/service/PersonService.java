package ru.netology.hibernate.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@org.springframework.stereotype.Service
public class PersonService {
    PersonRepository repository;

    public List<Person> getPersonByCity(String city) {
        return repository.getPersonByCity(city);
    }

}
