package sobiechq.springcards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.server.ResponseStatusException;
import sobiechq.springcards.Sessions.Session;
import sobiechq.springcards.Sessions.SessionFactory;

@RestController
@SpringBootApplication
public class SpringCardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCardsApplication.class, args);
    }


    private record SessionCreated(int sessionId){}
    @GetMapping("/session")
    @ResponseStatus(code = HttpStatus.CREATED)
    public SessionCreated createSession(){
        return new SessionCreated(SessionFactory.createSession().getId());
    }

    @PutMapping("/session/{sessionId}/{username}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@PathVariable String username, @PathVariable int sessionId) {
        if (SessionFactory.getSessionById(sessionId).isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Session with provided id does not exist");
        try {
            SessionFactory.getSessionById(sessionId).get().createUser(username);
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }
    @PutMapping("session")
    public void start(int sessionId){
        if (SessionFactory.getSessionById(sessionId).isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Session with provided id does not exist");
        SessionFactory.getSessionById(sessionId).get().start();
    }

    @GetMapping("/coffe")
    public String brewCoffe(){
        if(true)
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Nie da sie");
        return "Coffe";
    }

}
