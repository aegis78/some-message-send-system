package com.cyworld.message.api.controller;

import com.cyworld.message.result.BaseResult;
import com.cyworld.message.service.Telegram;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class MessageController {

    @Autowired
    Telegram telegram;

    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public BaseResult sampleSend(@RequestParam(value="msg", defaultValue="이것은 봇입니다.") String message) {
        BaseResult result = new BaseResult();

        result.setResultCode(200);
        result.setSendMessage(message);
        result.setSendType("Telegram1");

        log.debug("result = {}", result.getResultCode());
        log.debug("result = {}", result.getSendMessage());
        log.debug("result = {}", result.getSendType());

        return result;
    }

    /**
     * sns 구분자를 두어 slack or telegram msg 전송
     * @param token
     * @param text
     * @param sns
     * @return
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public BaseResult messageSend(@RequestParam(value = "token", required = true) String token,
                                  @RequestParam(value = "text", required = true) String text,
                                  @RequestParam(value = "sns", required = true) String sns) {
        BaseResult result = new BaseResult();
        

        return result;
    }

    /**
     * Telegram 채널로 Bot token을 통해 메시지를 보낸다.
     * @param token
     * @param text
     * @return
     * example URL : https://api.telegram.org/bot527604252:AAGh9GEWGionKV9iopqJ5LlejmLjN2_Dpyk/sendMessage?chat_id=@e_alarm&text=telegram
     */
    @RequestMapping(value = "/telegram/send", method = RequestMethod.POST)
    public BaseResult telegramSend(@RequestParam(value = "token", required = true) String token,
                                  @RequestParam(value = "channel", required = true) String channel,
                                  @RequestParam(value = "text", required = true) String text) {
        BaseResult result = new BaseResult();

        try {
            telegram.telegramSend(token, channel, text);
        } catch (Exception e) {
            log.error("[Exception printStack] = {}", e.fillInStackTrace());
            result.setResultCode(500);
            result.setSendMessage(e.getMessage());
            result.setSendType("telegram");
        }

        return result;
    }
}
