package org.pact.demo;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class APIController {


    @GetMapping(path = "/get", produces= MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, String> getUser(){
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        return map;
    }

}
