package org.pact.demo;


import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class APIController {


    @GetMapping(path = "/get", produces= MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, String> getUser() throws UnirestException {
        HttpRequest getRequest = Unirest.get("http://localhost:9090/api/get");

        JsonNode jsonNode = getRequest.asJson().getBody();

        HashMap<String, String> map = new HashMap<>();
        map.put("modifiedKey1", jsonNode.getObject().getString("key1"));
        map.put("modifiedKey2", jsonNode.getObject().getString("key2"));
        return map;

    }

}
