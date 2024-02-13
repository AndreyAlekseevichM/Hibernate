package ru.netology.hibernate.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.service.PersonService;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
public class PersonController {
    PersonService personService;

    @GetMapping("/person/by-city")
    public List<Person> getPersonByCity(@RequestParam("city") String city) {
        return personService.getPersonByCity(city);
    }
}
