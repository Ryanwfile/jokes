package dev.learning.jokes_mongo_artifact;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JokeRepository extends MongoRepository<Joke, ObjectId> {

    Optional<Joke> findJokeByJokeId(String jokeId);
    void deleteJokeByJokeId(String jokeId);
}
