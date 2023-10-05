package chatprogram;

public class ChatMessage {
    private User sender;
    private User receiver;
    private String message;

    public ChatMessage(User sender, User receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }



}
