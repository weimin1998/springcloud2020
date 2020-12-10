package com.weimin.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultMessage<T> {
    private int code;
    private String message;
    private T data;

    public ResultMessage(int code, String message) {
        this(code,message,null);
    }
}
