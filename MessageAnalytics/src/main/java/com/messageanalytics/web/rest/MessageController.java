package com.messageanalytics.web.rest;

import com.messageanalytics.Constants;
import com.messageanalytics.service.MessageService;
import com.messageanalytics.service.dto.CustomResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codahale.metrics.annotation.Timed;
import org.springframework.http.HttpStatus;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final Logger log = LoggerFactory.getLogger(MessageController.class);
    MessageService messageService;

    MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/top-five-users")
    @Timed
    public ResponseEntity<CustomResponseDTO> getTopFiveUsers() throws URISyntaxException {
        CustomResponseDTO customResponseDTO = new CustomResponseDTO();
        try {
            customResponseDTO.setData(messageService.getTopFiveUsers());
            customResponseDTO.setHttpStatus(HttpStatus.OK);
        } catch (Exception exception) {
            customResponseDTO.setSuccess(false);
            customResponseDTO.setMessage(Constants.ERROR);
            customResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CustomResponseDTO>(customResponseDTO, customResponseDTO.getHttpStatus());
    }
}
