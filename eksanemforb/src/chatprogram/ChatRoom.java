package chatprogram;

import java.util.ArrayList;

public class ChatRoom {
    private ArrayList<ChatObserver> observers = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();


    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
            addObserver(user);
        }
    }

    public void removeUser(User user) {
        if (users.contains(user)) {
            users.remove(user);
            removeObserver(user);
        }
    }
    public void sendMessage(ChatMessage message) {
        for (ChatObserver observer : observers) {
            observer.update(message);
        }
    }

    public void addObserver(ChatObserver o) {
        observers.add(o);
    }
    public void removeObserver(ChatObserver o) {
        observers.remove(o);
    }


}