package com.golaxy.exception;

import com.golaxy.utils.ErrorCode;

public class CustomException extends Exception {

    private final ErrorCode errorCode;

    public CustomException(ErrorCode errCode) {
        super(errCode.getMessage());
        this.errorCode = errCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
