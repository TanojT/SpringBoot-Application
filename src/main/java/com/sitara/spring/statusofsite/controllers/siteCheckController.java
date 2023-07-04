package com.sitara.spring.statusofsite.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class siteCheckController {
    private String siteIsUP = "Site is UP!!";
    private String siteIsDown = "Site is Down:(";

    @GetMapping("/checkUrl")
    public String fetchUrlStatus(@RequestParam String url){
        String returnMessage ="";
        try {
            URL urlobj=new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlobj.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode= connection.getResponseCode()/100;
            if(responseCode==2 || responseCode==3){
                returnMessage = siteIsUP;
                System.out.print(url+" : "+returnMessage );
            }else{
                returnMessage =siteIsDown;
                System.out.print(url+" : "+returnMessage );
            }
        } catch (MalformedURLException e) {
            returnMessage=siteIsDown;
            System.out.print(url+" : "+returnMessage );
            e.printStackTrace();
            return returnMessage;
        } catch (IOException e) {
            returnMessage=siteIsDown;
            System.out.print(url+" : "+returnMessage );
            e.printStackTrace();
            return returnMessage;
        }
        return returnMessage;
    }
}
