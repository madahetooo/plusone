package com.yat.firsthelloworldapp.models;

public class ChatMessage {

    private String id;
    private String messageText;
    private String messageUser;
    private String imageUrl;
    private long messageTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }

    public ChatMessage(String messageText, String messageUser , String imageUrl) {
        this.messageText = messageText;
        this.messageUser = messageUser;
        this.imageUrl = imageUrl;
        messageTime = (int)(System.currentTimeMillis()/1000);


    }

    public ChatMessage() {
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
