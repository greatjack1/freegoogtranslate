package com.wyre;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Translater
{
    public Translater(){

    }
    public String translate(String sourceLanguageCode,String targetLanguageCode,String textToTranslate) {
        try {
            URL url = new URL("https://translate.googleapis.com/translate_a/single?client=gtx&sl=" + sourceLanguageCode + "&tl=" + targetLanguageCode + "&dt=t&q=" + URLEncoder.encode(textToTranslate, "UTF-8"));
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.addRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
            String response = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response = response + line;
            }
            return response.substring(4, response.indexOf("\","));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "unable to translate this text";
    }

}

