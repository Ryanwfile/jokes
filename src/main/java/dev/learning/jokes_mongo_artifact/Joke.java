package dev.learning.jokes_mongo_artifact;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jokes")
public class Joke {
    @Id
    private ObjectId id;
    private String jokeId;
    private String title;
    private String content;
    private String author;
    private boolean isSafeForWork;
    private boolean isRhetorical;

    public Joke(ObjectId id, String jokeId, String title, String content, String author, boolean isSafeForWork, boolean isRhetorical) {
        this.id = id;
        this.jokeId = jokeId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.isSafeForWork = isSafeForWork;
        this.isRhetorical = isRhetorical;
    }
    public Joke(String jokeId, String title, String content, String author, boolean isSafeForWork, boolean isRhetorical){
        this.jokeId = jokeId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.isSafeForWork = isSafeForWork;
        this.isRhetorical = isRhetorical;
    }

    public Joke(){}

    public ObjectId getId() {
        return id;
    }
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }

    public String getJokeId() {
        return jokeId;
    }

    public void setJokeId(String jokeId) {
        this.jokeId = jokeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean getIsSafeForWork() {
        return isSafeForWork;
    }

    public void setSafeForWork(boolean safeForWork) {
        isSafeForWork = safeForWork;
    }

    public boolean getIsRhetorical() {
        return isRhetorical;
    }

    public void setRhetorical(boolean rhetorical) {
        isRhetorical = rhetorical;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", jokeId='" + jokeId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", isSafeForWork=" + isSafeForWork +
                ", isRhetorical=" + isRhetorical +
                '}';
    }
}
