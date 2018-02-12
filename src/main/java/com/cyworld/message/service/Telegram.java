package com.cyworld.message.service;

import com.cyworld.message.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;

@Slf4j
@Service
public class Telegram {
    final String TELEGRAMURL = "https://api.telegram.org/bot";
    final String METHOD = "/sendMessage";

    public String telegramSend(String apiKey, String channel, String sendTxt) throws Exception {
        String result = "";
        String sendURI = "";
        String params = "";

        sendURI = TELEGRAMURL + apiKey.trim() + METHOD;
        params = "chat_id=" + channel.trim() + "&text=" + URLEncoder.encode(sendTxt, "UTF-8");

        log.debug("[telegram URL = {}?{}]", sendURI, params);
        log.debug("[telegram TXT = {}]", sendTxt);

        result = Util.sendPost(sendURI, params);

        return result;
    }

}
