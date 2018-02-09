package com.cyworld.message.api.controller;

import com.cyworld.message.result.BaseResult;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class MessageController {

    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public BaseResult messageSend(@RequestParam(value="msg", defaultValue="이것은 봇입니다.") String message) {
        BaseResult result = new BaseResult();

        result.setResultCode(200);
        result.setSendMessage(message);
        result.setSendType("Telegram1");

        log.debug("result = {}", result.getResultCode());
        log.debug("result = {}", result.getSendMessage());
        log.debug("result = {}", result.getSendType());

        return result;
    }


}
