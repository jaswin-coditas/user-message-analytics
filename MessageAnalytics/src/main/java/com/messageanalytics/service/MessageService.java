package com.messageanalytics.service;

import com.messageanalytics.service.dto.UserMessageDTO;

import java.util.List;

public interface MessageService {

    List<UserMessageDTO> getTopFiveUsers();
}
