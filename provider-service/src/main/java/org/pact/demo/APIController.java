package org.pact.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class APIController {

    private DataRepository dataRepository = new DataRepository();


    @GetMapping("/get")
    public ResponseEntity<String> getUser(){
        String data = dataRepository.get();
        return ResponseEntity.ok().body(data);
    }

    @PutMapping("/put")
    public ResponseEntity<String> putUser(@PathVariable("data") String data){
        dataRepository.put(data);
        return ResponseEntity.ok(data);
    }

}
