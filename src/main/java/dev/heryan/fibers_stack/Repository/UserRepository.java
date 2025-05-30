package dev.heryan.fibers_stack.Repository;

import dev.heryan.fibers_stack.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
