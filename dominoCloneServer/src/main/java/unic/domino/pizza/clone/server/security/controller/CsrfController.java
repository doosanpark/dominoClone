package unic.domino.pizza.clone.server.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/csrf")
@RestController
public class CsrfController {

    @GetMapping
    public void csrfGet() {
        System.out.println("GET");
    }

    @PostMapping
    public void csrfPost() {
    	System.out.println("POST");
    }
}