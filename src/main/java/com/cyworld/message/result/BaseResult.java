package com.cyworld.message.result;

import lombok.Data;

@Data
public class BaseResult {
    private int resultCode = 200;
    private String sendMessage= "success";
    private String sendType = "telegram";
}
