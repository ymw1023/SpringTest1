package com.sparta.userfindapi.dto;

import lombok.Getter;

@Getter
public class ResponseMessageDto {
    private final String message;

    public ResponseMessageDto(String message) {
        this.message = message;
    }
}
