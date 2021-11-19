package ac.dnd.hackathonbackend.util;

import lombok.Data;

@Data
public class Message {
    private Object data;
    private String message;

    public Message(Object result, String message){
        this.data = result;
        this.message = message;
    }
}