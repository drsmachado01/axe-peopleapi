package br.com.axe.peopleapi.repository;

import br.com.axe.peopleapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {
}
