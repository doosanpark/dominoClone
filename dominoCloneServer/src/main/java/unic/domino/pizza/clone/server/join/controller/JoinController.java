package unic.domino.pizza.clone.server.join.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {
    @PostMapping("/join/select")
    public ResponseEntity<String> getUser(){
        String test = "success";
        return ResponseEntity.ok(test);
    }
}
