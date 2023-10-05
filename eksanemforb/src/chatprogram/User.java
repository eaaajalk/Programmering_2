package chatprogram;

import java.util.ArrayList;

public class User implements ChatObserver {
    private ArrayList<ChatMessage> receivedList = new ArrayList<>();

    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }

    public void enterChat(ChatRoom chatRoom) {
        chatRoom.addUser(this);
    }
    public void leaveChat(ChatRoom chatRoom) {
        chatRoom.removeUser(this);
    }

    @Override
    public void update(ChatMessage message) {
        receivedList.add(message);
    }
}
