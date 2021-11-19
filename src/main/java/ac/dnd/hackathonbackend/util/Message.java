package ac.dnd.hackathonbackend.util;

import lombok.Data;

@Data
public class Message {
    private String message;
    private Object data;

    public Message(Object result, String message){
        this.data = result;
        this.message = message;
    }
}