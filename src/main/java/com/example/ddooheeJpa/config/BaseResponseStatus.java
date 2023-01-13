package com.example.ddooheeJpa.config;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
    SUCCESS(true, 1000, "요청에 성공하였습니다."),
    SMS_SEND_SUCCESS(true, 1001, "SMS 요청에 성공했습니다."),
    SMS_VERIFICATION_SUCCESS(true, 1002, "SMS 인증에 성공했습니다."),
    NOT_USER(false, 1003, "실패");

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
