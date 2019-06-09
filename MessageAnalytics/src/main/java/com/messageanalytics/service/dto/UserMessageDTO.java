package com.messageanalytics.service.dto;

public class UserMessageDTO {
    private String frequentMessage;
    private long messageCount;

    private String userName;

    public String getFrequentMessage() {
        return frequentMessage;
    }

    public void setFrequentMessage(String frequentMessage) {
        this.frequentMessage = frequentMessage;
    }

    public long getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(long messageCount) {
        this.messageCount = messageCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
