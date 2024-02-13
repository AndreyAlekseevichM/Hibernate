package ru.netology.hibernate.repository;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import ru.netology.hibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@org.springframework.stereotype.Repository
public class PersonRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getPersonByCity(String city) {
        return entityManager.createQuery("SELECT p FROM Person p WHERE p.cityOfLiving =:city")
                .setParameter("city", city)
                .getResultList();
    }
}
