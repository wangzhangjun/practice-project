package com.study.exception;

import com.study.enums.ResultEnum;
import lombok.Getter;

@Getter
public class SellException extends RuntimeException {

    private Integer code;
    private String message;

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
