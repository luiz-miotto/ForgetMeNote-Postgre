package dnd.mlogger.repositories;

import dnd.mlogger.Role;
import dnd.mlogger.security.ERole;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
