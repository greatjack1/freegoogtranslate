package com.wyre;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * This class is used to perform the actual translating
 */
public class Translater
{
    /**
     * Public constructor with no arguement
     */
    public Translater(){

    }

    /**
     * Method to perform the actual translation
     * @param sourceLanguageCode The iso code representing the source language
     * @param targetLanguageCode The iso code representing the target language
     * @param textToTranslate The text to be translated
     * @return The string translated to the target language or a error message
     */
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

