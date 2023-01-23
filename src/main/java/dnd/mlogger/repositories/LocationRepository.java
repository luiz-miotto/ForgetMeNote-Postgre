package dnd.mlogger.repositories;

import dnd.mlogger.domain.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface LocationRepository extends MongoRepository<Location, String> {
}
