package com.messageanalytics.service.impl;

import com.messageanalytics.Constants;
import com.messageanalytics.service.MessageService;
import com.messageanalytics.service.dto.CustomResponseDTO;
import com.messageanalytics.service.dto.MessagesDTO;
import com.messageanalytics.service.dto.UserMessageDTO;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class MessageServiceImpl implements MessageService {

    private final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    private String getMostFrequentMessage(List<String> messages) {
        Map<String, Long> messageFrequencyMap = new HashMap<>();
        for (String message : messages) {
            Long currentCount = messageFrequencyMap.get(message);
            if (null == currentCount) {
                messageFrequencyMap.put(message, 1L);
            } else {
                messageFrequencyMap.put(message, ++currentCount);
            }
        }
        Long maxCount = 0L;
        String frequentMessage = StringUtils.EMPTY;
        for (Map.Entry<String, Long> entry : messageFrequencyMap.entrySet()) {
            if (maxCount < entry.getValue()) {
                maxCount = entry.getValue();
                frequentMessage = entry.getKey();
            }
        }
        return frequentMessage;
    }

    private Map<String, MessagesDTO> fetchDataAndAddUsersToMap() {
        RestTemplate restTemplate = new RestTemplate();
        String[] userMessages = restTemplate.getForObject(Constants.USER_MESSAGES_ENDPOINT, String[].class);
        Map<String, MessagesDTO> usersAndMessages = new HashMap<>();
        for (String userMessage : userMessages) {
            String[] userAndMessage = userMessage.split(Constants.COLON);
            MessagesDTO messagesDTO = usersAndMessages.get(userAndMessage[0]);
            if (null == messagesDTO) {
                messagesDTO = new MessagesDTO();
                messagesDTO.setUserName(userAndMessage[0]);
                messagesDTO.addMessage(userAndMessage[1]);
                messagesDTO.incrementMessageCount();
            } else {
                messagesDTO.setUserName(userAndMessage[0]);
                messagesDTO.addMessage(userAndMessage[1]);
                messagesDTO.incrementMessageCount();
            }
            usersAndMessages.put(userAndMessage[0], messagesDTO);
        }
        return usersAndMessages;
    }

    @Override
    public List<UserMessageDTO> getTopFiveUsers() {
        List<UserMessageDTO> topFiveUsers = new ArrayList<>();
        Set<MessagesDTO> sortedUsers = sortUsersByMessageCount(fetchDataAndAddUsersToMap());
        int userCount = 1;
        for (MessagesDTO messagesDTO : sortedUsers) {
            UserMessageDTO userMessageDTO = new UserMessageDTO();
            userMessageDTO.setUserName(messagesDTO.getUserName());
            userMessageDTO.setMessageCount(messagesDTO.getMessageCount());
            userMessageDTO.setFrequentMessage(getMostFrequentMessage(messagesDTO.getMessages()));
            topFiveUsers.add(userMessageDTO);
            userCount++;
            if (userCount == 6)
                break;
        }
        return topFiveUsers;
    }

    private Set<MessagesDTO> sortUsersByMessageCount(Map<String, MessagesDTO> usersAndMessages) {
        Set<MessagesDTO> sortedUsers = new TreeSet<>();
        for (Map.Entry<String, MessagesDTO> entry : usersAndMessages.entrySet()) {
            sortedUsers.add(entry.getValue());
        }
        return sortedUsers;
    }
}

