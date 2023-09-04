package dev.learning.jokes_mongo_artifact;
//https://www.youtube.com/watch?v=5PdEmeopJVQ&t=607s
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class JokesMongoArtifactApplication {

	public static void main(String[] args) {
		SpringApplication.run(JokesMongoArtifactApplication.class, args);
	}
}
