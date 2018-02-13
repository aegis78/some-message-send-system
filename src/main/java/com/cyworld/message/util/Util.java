package com.cyworld.message.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

@Slf4j
@Component
public class Util {
    public static String sendPost(String sendUrl, String parameters) throws Exception{
        String retResult = "";
        String line = "";


        // Send data
        URL url = new URL(sendUrl);
        URLConnection conn = url.openConnection();
        // If you invoke the method setDoOutput(true) on the URLConnection, it
        // will always use the POST method.
        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(parameters);
        wr.flush();

        // Get the response
        BufferedReader rd = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), "UTF-8"));

        while ((line = rd.readLine()) != null) {
            retResult += line;
            log.info("[======== jsonSend ] Result : " + retResult);
        }
        wr.close();
        rd.close();

        return retResult;
    }
}
