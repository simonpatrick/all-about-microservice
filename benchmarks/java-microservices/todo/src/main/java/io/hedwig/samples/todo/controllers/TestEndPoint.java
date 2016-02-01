package io.hedwig.samples.todo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by patrick on 16/2/1.
 */
@RestController
@RequestMapping("/test")
public class TestEndPoint {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Void> apiAvailable(){
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
