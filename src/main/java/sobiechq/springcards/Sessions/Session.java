package sobiechq.springcards.Sessions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class Session{
    private final int id;
    private boolean started = false;
    private final List<User> users = new ArrayList<>();
    protected Session(int id) {
        this.id = id;
    }
    public void createUser(String nickname){
        if (this.users.stream().anyMatch(u->u.getNickname().equals(nickname))
            || this.started)
            throw new IllegalStateException("Unable to add user to this session");
        this.users.add(new User(nickname));
    }
    public void start(){ // maybe runnable?
        this.started = true;
    }
    public boolean isStarted() {
        return this.started;
    }
}
