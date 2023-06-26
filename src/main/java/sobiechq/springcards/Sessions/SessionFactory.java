package sobiechq.springcards.Sessions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SessionFactory {
    private static int count = 0;
    private static final Map<Integer,Session> sessions = new HashMap<>();
    private SessionFactory(){}
    public static Session createSession(){
        sessions.put(++count, new Session(count));
        return sessions.get(count);
    }
    public static Optional<Session> getSessionById(int id){
        return Optional.ofNullable(sessions.get(id));
    }
}
