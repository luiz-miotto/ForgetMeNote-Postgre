package dnd.mlogger.repositories;

import dnd.mlogger.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonRepository extends MongoRepository<Person, String> {
}
