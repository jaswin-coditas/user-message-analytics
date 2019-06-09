package com.messageanalytics.service.dto;

import java.util.ArrayList;
import java.util.List;

public class MessagesDTO implements  Comparable<MessagesDTO>{

    private List<String> messages = new ArrayList<>();

    private long messageCount;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public void addMessage(String message) {
       this.messages.add(message);
    }
    public Long getMessageCount() {
        return messageCount;
    }
    public void setMessageCount(Long messageCount) {
        this.messageCount = messageCount;
    }
    public void incrementMessageCount() {
        ++this.messageCount;
    }

    public String toString() {
        return ""+messageCount;
    }


    @Override
    public int compareTo(MessagesDTO messagesDTO) {
        if(this.getMessageCount() >= messagesDTO.getMessageCount()) {
            return -1;
        } else return 1;
    }
}
