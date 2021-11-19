package ac.dnd.hackathonbackend.util;

import lombok.Data;

@Data
public class Message {
    private StatusEnum status;
    private String message;
    private Object data;

    public Message(){
        this.status = StatusEnum.BAD_REQUEST;
        this.data = null;
        this.message = null;
    }
    public Message(Object result, String Message,StatusEnum status){
        this.data = result;
        this.message = message;
        this.status = status;
    }
}
