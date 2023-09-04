package dev.learning.jokes_mongo_artifact;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JokeService {
    @Autowired
    private JokeRepository jokeRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<Joke> allJokes() {
        return jokeRepository.findAll();
    }

    public Optional<Joke> getJoke(String jokeId){
        return jokeRepository.findJokeByJokeId(jokeId);
    }

    public Joke createJoke(String jokeId, String title, String content, String author, boolean isSafeForWork, boolean isRhetorical){
        return jokeRepository.insert(new Joke(jokeId, title, content, author, isSafeForWork, isRhetorical));
    }

    public Joke updateJoke(String id, Joke jokePayload){
        Optional<Joke> jokeData = jokeRepository.findJokeByJokeId(id);

        if(jokeData.isPresent()){
            System.out.println("joke data is found, updating meow");
            Joke jokeToUpdate = jokeData.get();
            jokeToUpdate.setJokeId(jokePayload.getJokeId());
            jokeToUpdate.setTitle(jokePayload.getTitle());
            jokeToUpdate.setContent(jokePayload.getContent());
            jokeToUpdate.setAuthor(jokePayload.getAuthor());
            jokeToUpdate.setSafeForWork(jokePayload.getIsSafeForWork());
            jokeToUpdate.setRhetorical(jokeToUpdate.getIsRhetorical());
            return jokeRepository.save(jokeToUpdate);
        }
        else {
            return new Joke();
        }
    }

    public void deleteJokeByJokeId(String jokeId){
        Optional<Joke> jokeOptional = this.getJoke(jokeId);
        if(jokeOptional.isPresent()){
            System.out.println("Deleting joke meow");
            Joke jokeToDelete = jokeOptional.get();
            jokeRepository.deleteById(jokeToDelete.getId());
        }
    }

//    public Joke updateJoke(String jokeId, String title, String content, String author, boolean isSafeForWork, boolean isRhetorical){
//
//    }

//    public Joke updateJoke(String jokeId, String title, String content, String author, boolean isSafeForWork, boolean isRhetorical){
//        Joke joke = new Joke(jokeId, title, content, author, isSafeForWork, isRhetorical);
//        jokeRepository.insert(joke);
//        mongoTemplate.update(Joke.class)
//                .matching(Criteria.where("jokeId").is(jokeId))
//                .apply(new Update().push("content").value(joke));
//    }
}
