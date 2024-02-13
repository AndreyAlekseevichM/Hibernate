package ru.netology.hibernate.repository;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.entity.PersonId;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class DataGenerator implements CommandLineRunner {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var random = new Random();

        var cities = List.of("Moscow", "EKB", "Kazan");
        var names = List.of("Oleg", "Maxim", "Alexey");
        var surnames = List.of("Ivanov", "Petrov", "Sidorov");

        IntStream.range(0, 6)
                .forEach(i -> {
                    var person = Person.builder()
                            .personId(PersonId.builder()
                                    .name(names.get(random.nextInt(names.size())))
                                    .surname(surnames.get(random.nextInt(surnames.size())))
                                    .age(random.nextInt(60))
                                    .build())
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .phoneNumber(String.valueOf(random.nextInt(1234567)))
                            .build();
                    entityManager.persist(person);
                });
    }
}









