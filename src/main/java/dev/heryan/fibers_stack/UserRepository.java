package dev.heryan.fibers_stack;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    @Aggregation(pipeline = {
            "{ '$limit' : ?0 }"
    })
    List<User> findAll(long take);
}
