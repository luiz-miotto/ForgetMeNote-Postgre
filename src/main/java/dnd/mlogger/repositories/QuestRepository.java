package dnd.mlogger.repositories;

import dnd.mlogger.domain.Quest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface QuestRepository extends MongoRepository<Quest,String > {
}
