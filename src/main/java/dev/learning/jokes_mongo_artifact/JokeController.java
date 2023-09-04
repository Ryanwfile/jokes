package dev.learning.jokes_mongo_artifact;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//need Optional with try catch anywhere a responseEntity can fail

@RestController
@RequestMapping("/api/v1/jokes")
public class JokeController {
    @Autowired
    private JokeService jokeService;
    @GetMapping
    public ResponseEntity<List<Joke>> getAllJokes(){
        return new ResponseEntity<List<Joke>>(jokeService.allJokes(), HttpStatus.OK);
    }

    @GetMapping("/{jokeId}")
    public ResponseEntity<Optional<Joke>> getJoke(@PathVariable String jokeId){
        return new ResponseEntity<Optional<Joke>>(jokeService.getJoke(jokeId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Joke> createNewJoke(@RequestBody Joke jokePayload){
        return new ResponseEntity<Joke>(jokeService.createJoke(
                jokePayload.getJokeId(),
                jokePayload.getTitle(),
                jokePayload.getContent(),
                jokePayload.getAuthor(),
                jokePayload.getIsSafeForWork(),
                jokePayload.getIsRhetorical()
        ), HttpStatus.OK);
    }

    @PutMapping("/{jokeId}")
    public ResponseEntity<Joke> updateJoke(@PathVariable("jokeId") String id, @RequestBody Joke jokePayload){
        return new ResponseEntity<Joke>(jokeService.updateJoke(id, jokePayload), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteJokeById(@PathVariable("id") String id){
        jokeService.deleteJokeByJokeId(id);
    }

}
