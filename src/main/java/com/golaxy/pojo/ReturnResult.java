package com.golaxy.pojo;

import com.golaxy.utils.ErrorCode;

public class ReturnResult {

    public String code;
    public String msg;
    public Object data;

    public ReturnResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ReturnResult(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
        this.data = "";
    }
}
