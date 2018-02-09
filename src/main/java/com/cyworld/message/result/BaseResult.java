package com.cyworld.message.result;

import lombok.Data;

@Data
public class BaseResult {
    private int resultCode;
    private String sendMessage;
    private String sendType;
}
